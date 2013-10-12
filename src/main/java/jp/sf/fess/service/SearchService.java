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

package jp.sf.fess.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;

import jp.sf.fess.Constants;
import jp.sf.fess.ResultOffsetExceededException;
import jp.sf.fess.entity.FacetInfo;
import jp.sf.fess.entity.FieldAnalysisResponse;
import jp.sf.fess.entity.GeoInfo;
import jp.sf.fess.entity.MoreLikeThisInfo;
import jp.sf.fess.entity.SearchQuery;
import jp.sf.fess.entity.SearchQuery.SortField;
import jp.sf.fess.entity.SuggestResponse;
import jp.sf.fess.helper.QueryHelper;
import jp.sf.fess.solr.FessSolrQueryException;
import jp.sf.fess.util.QueryResponseList;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.util.NamedList;
import org.codelibs.solr.lib.SolrGroup;
import org.codelibs.solr.lib.SolrGroupManager;
import org.codelibs.solr.lib.policy.QueryType;
import org.seasar.framework.container.SingletonS2Container;
import org.seasar.framework.util.StringUtil;

public class SearchService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Resource
    protected SolrGroupManager solrGroupManager;

    @Resource
    protected QueryHelper queryHelper;

    public List<Map<String, Object>> selectList(final String query,
            final FacetInfo facetInfo, final int start, final int rows,
            final GeoInfo geoInfo, final MoreLikeThisInfo mltInfo) {
        return selectList(query, facetInfo, start, rows, geoInfo, mltInfo, true);
    }

    public List<Map<String, Object>> selectList(final String query,
            final FacetInfo facetInfo, final int start, final int rows,
            final GeoInfo geoInfo, final MoreLikeThisInfo mltInfo,
            final boolean forUser) {
        if (start > queryHelper.getMaxSearchResultOffset()) {
            throw new ResultOffsetExceededException(
                    "The number of result size is exceeded.");
        }

        final long startTime = System.currentTimeMillis();

        final SolrGroup solrGroup = solrGroupManager
                .getSolrGroup(QueryType.QUERY);

        QueryResponse queryResponse = null;
        final SolrQuery solrQuery = new SolrQuery();
        final SearchQuery searchQuery = queryHelper.build(query, forUser);
        final String q = searchQuery.getQuery();
        if (StringUtil.isNotBlank(q)) {
            // fields
            solrQuery.setFields(queryHelper.getResponseFields());
            // query
            solrQuery.setQuery(q);
            solrQuery.setStart(start);
            solrQuery.setRows(rows);
            solrQuery.set("mm", searchQuery.getMinimumShouldMatch());
            for (final Map.Entry<String, String[]> entry : queryHelper
                    .getQueryParamMap().entrySet()) {
                solrQuery.set(entry.getKey(), entry.getValue());
            }
            // filter query
            if (searchQuery.hasFilterQueries()) {
                solrQuery.addFilterQuery(searchQuery.getFilterQueries());
            }
            // sort
            final SortField[] sortFields = searchQuery.getSortFields();
            if (sortFields.length != 0) {
                for (final SortField sortField : sortFields) {
                    solrQuery
                            .setSortField(
                                    sortField.getField(),
                                    Constants.DESC.equals(sortField.getOrder()) ? SolrQuery.ORDER.desc
                                            : SolrQuery.ORDER.asc);
                }
            } else if (queryHelper.hasDefaultSortFields()) {
                for (final SortField sortField : queryHelper
                        .getDefaultSortFields()) {
                    solrQuery
                            .setSortField(
                                    sortField.getField(),
                                    Constants.DESC.equals(sortField.getOrder()) ? SolrQuery.ORDER.desc
                                            : SolrQuery.ORDER.asc);
                }
            }
            // highlighting
            if (queryHelper.getHighlightingFields() != null
                    && queryHelper.getHighlightingFields().length != 0) {
                for (final String hf : queryHelper.getHighlightingFields()) {
                    solrQuery.addHighlightField(hf);
                }
                solrQuery.setHighlightSnippets(queryHelper
                        .getHighlightSnippetSize());
            }
            // shards
            if (queryHelper.getShards() != null) {
                solrQuery.setParam("shards", queryHelper.getShards());
            }
            // geo
            if (geoInfo != null && geoInfo.isAvailable()) {
                solrQuery.addFilterQuery(geoInfo.toGeoQueryString());
                final String additionalGeoQuery = queryHelper
                        .getAdditionalGeoQuery();
                if (StringUtil.isNotBlank(additionalGeoQuery)) {
                    solrQuery.addFilterQuery(additionalGeoQuery);
                }
            }
            // facets
            if (facetInfo != null) {
                solrQuery.setFacet(true);
                if (facetInfo.field != null) {
                    for (final String f : facetInfo.field) {
                        if (queryHelper.isFacetField(f)) {
                            solrQuery.addFacetField(f);
                        } else {
                            throw new FessSolrQueryException("EFESS0002",
                                    new Object[] { f });
                        }
                    }
                }
                if (facetInfo.query != null) {
                    for (final String fq : facetInfo.query) {
                        final String facetQuery = queryHelper
                                .buildFacetQuery(fq);
                        if (StringUtil.isNotBlank(facetQuery)) {
                            solrQuery.addFacetQuery(facetQuery);
                        } else {
                            throw new FessSolrQueryException("EFESS0003",
                                    new Object[] { fq, facetQuery });
                        }
                    }
                }
                if (facetInfo.limit != null) {
                    solrQuery.setFacetLimit(Integer.parseInt(facetInfo.limit));
                }
                if (facetInfo.minCount != null) {
                    solrQuery.setFacetMinCount(Integer
                            .parseInt(facetInfo.minCount));
                }
                if (facetInfo.missing != null) {
                    solrQuery.setFacetMissing(Boolean
                            .parseBoolean(facetInfo.missing));
                }
                if (facetInfo.prefix != null) {
                    solrQuery.setFacetPrefix(facetInfo.prefix);
                }
                if (facetInfo.sort != null
                        && queryHelper.isFacetSortValue(facetInfo.sort)) {
                    solrQuery.setFacetSort(facetInfo.sort);
                }
            }
            // mlt
            if (mltInfo != null) {
                final String mltField = queryHelper
                        .getMoreLikeThisField(mltInfo.field);
                if (mltField != null) {
                    solrQuery.set("mlt", true);
                    if (mltInfo.count != null) {
                        solrQuery.set("mlt.count",
                                Integer.parseInt(mltInfo.count));
                    }
                    solrQuery.set("mlt.fl", mltField);
                }
            }

            if (queryHelper.getTimeAllowed() >= 0) {
                solrQuery.setTimeAllowed(queryHelper.getTimeAllowed());
            }
            final Set<Entry<String, String[]>> paramSet = queryHelper
                    .getRequestParameterSet();
            if (!paramSet.isEmpty()) {
                for (final Map.Entry<String, String[]> entry : paramSet) {
                    solrQuery.set(entry.getKey(), entry.getValue());
                }
            }

            queryResponse = solrGroup.query(solrQuery, SolrRequest.METHOD.POST);
        }
        final long execTime = System.currentTimeMillis() - startTime;

        final QueryResponseList queryResponseList = SingletonS2Container
                .getComponent(QueryResponseList.class);
        queryResponseList.init(queryResponse, rows);
        queryResponseList.setSearchQuery(q);
        queryResponseList.setSolrQuery(solrQuery.toString());
        queryResponseList.setExecTime(execTime);
        return queryResponseList;
    }

    public SuggestResponse getSuggestResponse(final String fieldName,
            final String q, final int rows) {

        final String qt = queryHelper.getSuggestQueryType(fieldName);
        if (qt == null) {
            throw new FessSolrQueryException("EFESS0001",
                    new Object[] { fieldName });
        }

        final long startTime = System.currentTimeMillis();

        final SolrGroup solrGroup = solrGroupManager
                .getSolrGroup(QueryType.QUERY);

        QueryResponse queryResponse = null;
        final SolrQuery solrQuery = new SolrQuery();
        if (StringUtil.isNotBlank(q)) {
            // query
            solrQuery.setQuery(q);
            // path
            solrQuery.setParam(CommonParams.QT, qt);
            // size
            solrQuery.set("spellcheck.count", rows);

            if (queryHelper.getTimeAllowed() >= 0) {
                solrQuery.setTimeAllowed(queryHelper.getTimeAllowed());
            }

            queryResponse = solrGroup.query(solrQuery, SolrRequest.METHOD.POST);

        }
        final long execTime = System.currentTimeMillis() - startTime;

        final SuggestResponse suggestResponse = new SuggestResponse(
                queryResponse);
        suggestResponse.setSearchQuery(q);
        suggestResponse.setExecTime(execTime);
        return suggestResponse;
    }

    public FieldAnalysisResponse getFieldAnalysisResponse(
            final String[] fieldNames, final String fieldValue) {
        final FieldAnalysisRequest request = new FieldAnalysisRequest();

        for (final String fieldName : fieldNames) {
            if (!queryHelper.isAnalysisFieldName(fieldName)) {
                throw new FessSolrQueryException("EFESS0001",
                        new Object[] { fieldName });
            }
            request.addFieldName(fieldName);
        }
        request.setFieldValue(fieldValue);

        final long startTime = System.currentTimeMillis();

        final SolrGroup solrGroup = solrGroupManager
                .getSolrGroup(QueryType.REQUEST);

        final NamedList<Object> response = solrGroup.request(request);

        final long execTime = System.currentTimeMillis() - startTime;

        final FieldAnalysisResponse fieldAnalysisResponse = new FieldAnalysisResponse(
                response);
        fieldAnalysisResponse.setExecTime(execTime);
        return fieldAnalysisResponse;
    }
}