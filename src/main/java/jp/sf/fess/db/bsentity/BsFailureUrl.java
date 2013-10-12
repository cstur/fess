/*
 * Copyright 2009-2013 the Fess Project and the Others.
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

package jp.sf.fess.db.bsentity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jp.sf.fess.db.allcommon.DBMetaInstanceHandler;
import jp.sf.fess.db.exentity.FailureUrl;
import jp.sf.fess.db.exentity.FileCrawlingConfig;
import jp.sf.fess.db.exentity.WebCrawlingConfig;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;

/**
 * The entity of FAILURE_URL as TABLE. <br />
 * <pre>
 * [primary-key]
 *     ID
 * 
 * [column]
 *     ID, URL, THREAD_NAME, ERROR_NAME, ERROR_LOG, ERROR_COUNT, LAST_ACCESS_TIME, WEB_CONFIG_ID, FILE_CONFIG_ID
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     ID
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     FILE_CRAWLING_CONFIG, WEB_CRAWLING_CONFIG
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     fileCrawlingConfig, webCrawlingConfig
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long id = entity.getId();
 * String url = entity.getUrl();
 * String threadName = entity.getThreadName();
 * String errorName = entity.getErrorName();
 * String errorLog = entity.getErrorLog();
 * Integer errorCount = entity.getErrorCount();
 * java.sql.Timestamp lastAccessTime = entity.getLastAccessTime();
 * Long webConfigId = entity.getWebConfigId();
 * Long fileConfigId = entity.getFileConfigId();
 * entity.setId(id);
 * entity.setUrl(url);
 * entity.setThreadName(threadName);
 * entity.setErrorName(errorName);
 * entity.setErrorLog(errorLog);
 * entity.setErrorCount(errorCount);
 * entity.setLastAccessTime(lastAccessTime);
 * entity.setWebConfigId(webConfigId);
 * entity.setFileConfigId(fileConfigId);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsFailureUrl implements Entity, Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _id;

    /** URL: {IX, NotNull, VARCHAR(4000)} */
    protected String _url;

    /** THREAD_NAME: {NotNull, VARCHAR(30)} */
    protected String _threadName;

    /** ERROR_NAME: {IX+, VARCHAR(255)} */
    protected String _errorName;

    /** ERROR_LOG: {VARCHAR(4000)} */
    protected String _errorLog;

    /** ERROR_COUNT: {IX+, NotNull, INTEGER(10)} */
    protected Integer _errorCount;

    /** LAST_ACCESS_TIME: {IX+, NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _lastAccessTime;

    /** WEB_CONFIG_ID: {IX, BIGINT(19), FK to WEB_CRAWLING_CONFIG} */
    protected Long _webConfigId;

    /** FILE_CONFIG_ID: {IX, BIGINT(19), FK to FILE_CRAWLING_CONFIG} */
    protected Long _fileConfigId;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    @Override
    public String getTableDbName() {
        return "FAILURE_URL";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTablePropertyName() { // according to Java Beans rule
        return "failureUrl";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    @Override
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasPrimaryKeyValue() {
        if (getId() == null) {
            return false;
        }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** FILE_CRAWLING_CONFIG by my FILE_CONFIG_ID, named 'fileCrawlingConfig'. */
    protected FileCrawlingConfig _fileCrawlingConfig;

    /**
     * FILE_CRAWLING_CONFIG by my FILE_CONFIG_ID, named 'fileCrawlingConfig'.
     * @return The entity of foreign property 'fileCrawlingConfig'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public FileCrawlingConfig getFileCrawlingConfig() {
        return _fileCrawlingConfig;
    }

    /**
     * FILE_CRAWLING_CONFIG by my FILE_CONFIG_ID, named 'fileCrawlingConfig'.
     * @param fileCrawlingConfig The entity of foreign property 'fileCrawlingConfig'. (NullAllowed)
     */
    public void setFileCrawlingConfig(
            final FileCrawlingConfig fileCrawlingConfig) {
        _fileCrawlingConfig = fileCrawlingConfig;
    }

    /** WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'. */
    protected WebCrawlingConfig _webCrawlingConfig;

    /**
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @return The entity of foreign property 'webCrawlingConfig'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public WebCrawlingConfig getWebCrawlingConfig() {
        return _webCrawlingConfig;
    }

    /**
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @param webCrawlingConfig The entity of foreign property 'webCrawlingConfig'. (NullAllowed)
     */
    public void setWebCrawlingConfig(final WebCrawlingConfig webCrawlingConfig) {
        _webCrawlingConfig = webCrawlingConfig;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof BsFailureUrl)) {
            return false;
        }
        final BsFailureUrl otherEntity = (BsFailureUrl) other;
        if (!xSV(getId(), otherEntity.getId())) {
            return false;
        }
        return true;
    }

    protected boolean xSV(final Object value1, final Object value2) { // isSameValue()
        return InternalUtil.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getId());
        return result;
    }

    protected int xCH(final int result, final Object value) { // calculateHashcode()
        return InternalUtil.calculateHashcode(result, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    @Override
    public String toString() {
        return buildDisplayString(InternalUtil.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toStringWithRelation() {
        final StringBuilder sb = new StringBuilder();
        sb.append(toString());
        final String l = "\n  ";
        if (_fileCrawlingConfig != null) {
            sb.append(l).append(
                    xbRDS(_fileCrawlingConfig, "fileCrawlingConfig"));
        }
        if (_webCrawlingConfig != null) {
            sb.append(l).append(xbRDS(_webCrawlingConfig, "webCrawlingConfig"));
        }
        return sb.toString();
    }

    protected String xbRDS(final Entity e, final String name) { // buildRelationDisplayString()
        return e.buildDisplayString(name, true, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String buildDisplayString(final String name, final boolean column,
            final boolean relation) {
        final StringBuilder sb = new StringBuilder();
        if (name != null) {
            sb.append(name).append(column || relation ? ":" : "");
        }
        if (column) {
            sb.append(buildColumnString());
        }
        if (relation) {
            sb.append(buildRelationString());
        }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }

    protected String buildColumnString() {
        final StringBuilder sb = new StringBuilder();
        final String delimiter = ", ";
        sb.append(delimiter).append(getId());
        sb.append(delimiter).append(getUrl());
        sb.append(delimiter).append(getThreadName());
        sb.append(delimiter).append(getErrorName());
        sb.append(delimiter).append(getErrorLog());
        sb.append(delimiter).append(getErrorCount());
        sb.append(delimiter).append(getLastAccessTime());
        sb.append(delimiter).append(getWebConfigId());
        sb.append(delimiter).append(getFileConfigId());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    protected String buildRelationString() {
        final StringBuilder sb = new StringBuilder();
        final String c = ",";
        if (_fileCrawlingConfig != null) {
            sb.append(c).append("fileCrawlingConfig");
        }
        if (_webCrawlingConfig != null) {
            sb.append(c).append("webCrawlingConfig");
        }
        if (sb.length() > c.length()) {
            sb.delete(0, c.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    @Override
    public FailureUrl clone() {
        try {
            return (FailureUrl) super.clone();
        } catch (final CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: "
                    + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getId() {
        return _id;
    }

    /**
     * [set] ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param id The value of the column 'ID'. (basically NotNull if update: for the constraint)
     */
    public void setId(final Long id) {
        __modifiedProperties.addPropertyName("id");
        _id = id;
    }

    /**
     * [get] URL: {IX, NotNull, VARCHAR(4000)} <br />
     * @return The value of the column 'URL'. (basically NotNull if selected: for the constraint)
     */
    public String getUrl() {
        return _url;
    }

    /**
     * [set] URL: {IX, NotNull, VARCHAR(4000)} <br />
     * @param url The value of the column 'URL'. (basically NotNull if update: for the constraint)
     */
    public void setUrl(final String url) {
        __modifiedProperties.addPropertyName("url");
        _url = url;
    }

    /**
     * [get] THREAD_NAME: {NotNull, VARCHAR(30)} <br />
     * @return The value of the column 'THREAD_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getThreadName() {
        return _threadName;
    }

    /**
     * [set] THREAD_NAME: {NotNull, VARCHAR(30)} <br />
     * @param threadName The value of the column 'THREAD_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setThreadName(final String threadName) {
        __modifiedProperties.addPropertyName("threadName");
        _threadName = threadName;
    }

    /**
     * [get] ERROR_NAME: {IX+, VARCHAR(255)} <br />
     * @return The value of the column 'ERROR_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getErrorName() {
        return _errorName;
    }

    /**
     * [set] ERROR_NAME: {IX+, VARCHAR(255)} <br />
     * @param errorName The value of the column 'ERROR_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setErrorName(final String errorName) {
        __modifiedProperties.addPropertyName("errorName");
        _errorName = errorName;
    }

    /**
     * [get] ERROR_LOG: {VARCHAR(4000)} <br />
     * @return The value of the column 'ERROR_LOG'. (NullAllowed even if selected: for no constraint)
     */
    public String getErrorLog() {
        return _errorLog;
    }

    /**
     * [set] ERROR_LOG: {VARCHAR(4000)} <br />
     * @param errorLog The value of the column 'ERROR_LOG'. (NullAllowed: null update allowed for no constraint)
     */
    public void setErrorLog(final String errorLog) {
        __modifiedProperties.addPropertyName("errorLog");
        _errorLog = errorLog;
    }

    /**
     * [get] ERROR_COUNT: {IX+, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'ERROR_COUNT'. (basically NotNull if selected: for the constraint)
     */
    public Integer getErrorCount() {
        return _errorCount;
    }

    /**
     * [set] ERROR_COUNT: {IX+, NotNull, INTEGER(10)} <br />
     * @param errorCount The value of the column 'ERROR_COUNT'. (basically NotNull if update: for the constraint)
     */
    public void setErrorCount(final Integer errorCount) {
        __modifiedProperties.addPropertyName("errorCount");
        _errorCount = errorCount;
    }

    /**
     * [get] LAST_ACCESS_TIME: {IX+, NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'LAST_ACCESS_TIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getLastAccessTime() {
        return _lastAccessTime;
    }

    /**
     * [set] LAST_ACCESS_TIME: {IX+, NotNull, TIMESTAMP(23, 10)} <br />
     * @param lastAccessTime The value of the column 'LAST_ACCESS_TIME'. (basically NotNull if update: for the constraint)
     */
    public void setLastAccessTime(final java.sql.Timestamp lastAccessTime) {
        __modifiedProperties.addPropertyName("lastAccessTime");
        _lastAccessTime = lastAccessTime;
    }

    /**
     * [get] WEB_CONFIG_ID: {IX, BIGINT(19), FK to WEB_CRAWLING_CONFIG} <br />
     * @return The value of the column 'WEB_CONFIG_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Long getWebConfigId() {
        return _webConfigId;
    }

    /**
     * [set] WEB_CONFIG_ID: {IX, BIGINT(19), FK to WEB_CRAWLING_CONFIG} <br />
     * @param webConfigId The value of the column 'WEB_CONFIG_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setWebConfigId(final Long webConfigId) {
        __modifiedProperties.addPropertyName("webConfigId");
        _webConfigId = webConfigId;
    }

    /**
     * [get] FILE_CONFIG_ID: {IX, BIGINT(19), FK to FILE_CRAWLING_CONFIG} <br />
     * @return The value of the column 'FILE_CONFIG_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Long getFileConfigId() {
        return _fileConfigId;
    }

    /**
     * [set] FILE_CONFIG_ID: {IX, BIGINT(19), FK to FILE_CRAWLING_CONFIG} <br />
     * @param fileConfigId The value of the column 'FILE_CONFIG_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setFileConfigId(final Long fileConfigId) {
        __modifiedProperties.addPropertyName("fileConfigId");
        _fileConfigId = fileConfigId;
    }
}