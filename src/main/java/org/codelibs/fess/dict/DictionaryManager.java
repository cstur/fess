/*
 * Copyright 2009-2015 the CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.codelibs.fess.dict;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.codelibs.core.io.FileUtil;
import org.codelibs.elasticsearch.runner.net.Curl;
import org.codelibs.elasticsearch.runner.net.CurlResponse;
import org.codelibs.fess.Constants;
import org.dbflute.optional.OptionalEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DictionaryManager {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryManager.class);

    protected String esUrl = "http://localhost:9201";

    protected List<DictionaryCreator> creatorList = new ArrayList<>();

    @PostConstruct
    public void init() {
        creatorList.forEach(creator -> {
            creator.setDictionaryManager(this);
        });
    }

    public DictionaryFile<? extends DictionaryItem>[] getDictionaryFiles() {
        try (CurlResponse response = Curl.get(esUrl + "/_configsync/file").param("fields", "path,@timestamp").execute()) {
            Map<String, Object> contentMap = response.getContentAsMap();
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> fileList = (List<Map<String, Object>>) contentMap.get("file");
            return fileList
                    .stream()
                    .map(fileMap -> {
                        try {
                            String path = fileMap.get("path").toString();
                            Date timestamp =
                                    new SimpleDateFormat(Constants.DATE_FORMAT_ISO_8601_EXTEND_UTC).parse(fileMap.get("@timestamp")
                                            .toString());
                            for (final DictionaryCreator creator : creatorList) {
                                DictionaryFile<? extends DictionaryItem> file = creator.create(path, timestamp);
                                if (file != null) {
                                    return file;
                                }
                            }
                        } catch (Exception e) {
                            logger.warn("Failed to load " + fileMap, e);
                        }
                        return null;
                    }).filter(file -> file != null).toArray(n -> new DictionaryFile<?>[n]);
        } catch (IOException e) {
            throw new DictionaryException("Failed to access dictionaries", e);
        }
    }

    public OptionalEntity<DictionaryFile<? extends DictionaryItem>> getDictionaryFile(final String id) {
        for (DictionaryFile<? extends DictionaryItem> dictFile : getDictionaryFiles()) {
            if (dictFile.getId().equals(id)) {
                return OptionalEntity.of(dictFile);
            }
        }
        return OptionalEntity.empty();
    }

    public void store(DictionaryFile<? extends DictionaryItem> dictFile, File file) {
        getDictionaryFile(dictFile.getId()).ifPresent(currentFile -> {
            if (currentFile.getTimestamp().getTime() > dictFile.getTimestamp().getTime()) {
                throw new DictionaryException(dictFile.getPath() + " was updated.");
            }

            // TODO use stream
                try (CurlResponse response =
                        Curl.post(esUrl + "/_configsync/file").param("path", dictFile.getPath()).body(FileUtil.readUTF8(file)).execute()) {
                    Map<String, Object> contentMap = response.getContentAsMap();
                    if (!Constants.TRUE.equalsIgnoreCase(contentMap.get("acknowledged").toString())) {
                        throw new DictionaryException("Failed to update " + dictFile.getPath());
                    }
                } catch (IOException e) {
                    throw new DictionaryException("Failed to update " + dictFile.getPath(), e);
                }

            }).orElse(() -> {
            throw new DictionaryException(dictFile.getPath() + " does not exist.");
        });
    }

    public InputStream getContentInputStream(DictionaryFile<? extends DictionaryItem> dictFile) {
        try {
            return Curl.get(esUrl + "/_configsync/file").param("path", dictFile.getPath()).execute().getContentAsStream();
        } catch (IOException e) {
            throw new DictionaryException("Failed to access " + dictFile.getPath(), e);
        }
    }

    public String getEsUrl() {
        return esUrl;
    }

    public void setEsUrl(String esUrl) {
        this.esUrl = esUrl;
    }

    public void addCreator(DictionaryCreator creator) {
        creatorList.add(creator);
    }

}