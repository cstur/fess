/*
 * Copyright 2012-2015 CodeLibs Project and the Others.
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
package org.codelibs.fess.mylasta.direction;

import org.codelibs.core.lang.StringUtil;
import org.codelibs.fess.Constants;
import org.codelibs.fess.util.ComponentUtil;
import org.codelibs.fess.util.StreamUtil;

public interface FessProp {

    //
    // system.properties
    //

    public default String getSystemProperty(final String key) {
        return ComponentUtil.getSystemProperties().getProperty(key);
    }

    public default String getProperty(final String key, final String defaultValue) {
        return ComponentUtil.getSystemProperties().getProperty(key, defaultValue);
    }

    public default void setLoginRequired(final boolean value) {
        ComponentUtil.getSystemProperties().setProperty(Constants.LOGIN_REQUIRED_PROPERTY, value ? Constants.TRUE : Constants.FALSE);
    }

    public default boolean isLoginRequired() {
        return Constants.TRUE.equalsIgnoreCase(ComponentUtil.getSystemProperties().getProperty(Constants.LOGIN_REQUIRED_PROPERTY,
                Constants.FALSE));
    }

    public default void setWebApiPopularWord(final boolean value) {
        ComponentUtil.getSystemProperties().setProperty(Constants.WEB_API_POPULAR_WORD_PROPERTY, value ? Constants.TRUE : Constants.FALSE);
    }

    public default boolean isWebApiPopularWord() {
        return Constants.TRUE.equalsIgnoreCase(ComponentUtil.getSystemProperties().getProperty(Constants.WEB_API_POPULAR_WORD_PROPERTY,
                Constants.TRUE));
    }

    public default String getLdapInitialContextFactory() {
        return getProperty(Constants.LDAP_INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    }

    public default String getLdapSecurityAuthentication() {
        return getProperty(Constants.LDAP_SECURITY_AUTHENTICATION, "simple");
    }

    public default String getLdapProviderUrl() {
        return getSystemProperty(Constants.LDAP_PROVIDER_URL);
    }

    public default String getLdapSecurityPrincipal(final String username) {
        return String.format(getProperty(Constants.LDAP_SECURITY_PRINCIPAL, StringUtil.EMPTY), username);
    }

    public default String getLdapBaseDn() {
        return getSystemProperty(Constants.LDAP_BASE_DN);
    }

    public default String getLdapAccountFilter() {
        return getSystemProperty(Constants.LDAP_ACCOUNT_FILTER);
    }

    //
    // fess_*.properties
    //

    String getAuthenticationAdminRoles();

    public default String[] getAuthenticationAdminRolesAsArray() {
        return getAuthenticationAdminRoles().split(",");
    }

    String getJvmCrawlerOptions();

    public default String[] getJvmCrawlerOptionsAsArray() {
        return getJvmCrawlerOptions().split("\n");
    }

    String getJvmSuggestOptions();

    public default String[] getJvmSuggestOptionsAsArray() {
        return getJvmSuggestOptions().split("\n");
    }

    String getCrawlerDocumentHtmlPrunedTags();

    public default String[] getCrawlerDocumentHtmlPrunedTagsAsArray() {
        return getCrawlerDocumentHtmlPrunedTags().split(",");
    }

    String getCrawlerDocumentCacheHtmlMimetypes();

    public default boolean isHtmlMimetypeForCache(final String mimetype) {
        final String[] mimetypes = getCrawlerDocumentCacheHtmlMimetypes().split(",");
        if (mimetypes.length == 1 && StringUtil.isBlank(mimetypes[0])) {
            return true;
        }
        return StreamUtil.of(mimetypes).anyMatch(s -> s.equalsIgnoreCase(mimetype));
    }

    String getCrawlerDocumentCacheSupportedMimetypes();

    public default boolean isSupportedDocumentCacheMimetypes(final String mimetype) {
        final String[] mimetypes = getCrawlerDocumentCacheSupportedMimetypes().split(",");
        if (mimetypes.length == 1 && StringUtil.isBlank(mimetypes[0])) {
            return true;
        }
        return StreamUtil.of(mimetypes).anyMatch(s -> s.equalsIgnoreCase(mimetype));
    }

    String getIndexerClickCountEnabled();

    public default boolean getIndexerClickCountEnabledAsBoolean() {
        return Constants.TRUE.equalsIgnoreCase(getIndexerClickCountEnabled());
    }

    String getIndexerFavoriteCountEnabled();

    public default boolean getIndexerFavoriteCountEnabledAsBoolean() {
        return Constants.TRUE.equalsIgnoreCase(getIndexerFavoriteCountEnabled());
    }

    String getIndexerThreadDumpEnabled();

    public default boolean getIndexerThreadDumpEnabledAsBoolean() {
        return Constants.TRUE.equalsIgnoreCase(getIndexerThreadDumpEnabled());
    }

    String getIndexBackupTargets();

    public default String[] getIndexBackupTargetsAsArray() {
        return getIndexBackupTargets().split(",");
    }

    String getJobSystemJobIds();

    public default boolean isSystemJobId(String id) {
        if (StringUtil.isBlank(getJobSystemJobIds())) {
            return false;
        }
        return StreamUtil.of(getJobSystemJobIds().split(",")).anyMatch(s -> s.equals(id));
    }

    String getSmbAvailableSidTypes();

    public default boolean isAvailableSmbSidType(int sidType) {
        if (StringUtil.isBlank(getSmbAvailableSidTypes())) {
            return false;
        }
        final String value = Integer.toString(sidType);
        return StreamUtil.of(getSmbAvailableSidTypes().split(",")).anyMatch(s -> {
            return s.equals(value);
        });
    }

    String getSupportedLanguages();

    public default String[] getSupportedLanguagesAsArray() {
        return StreamUtil.of(getSupportedLanguages().split(",")).filter(s -> StringUtil.isNotBlank(s)).toArray(n -> new String[n]);
    }

    String getOnlineHelpSupportedLangs();

    public default boolean isOnlineHelpSupportedLang(String lang) {
        if (StringUtil.isBlank(getOnlineHelpSupportedLangs())) {
            return false;
        }
        return StreamUtil.of(getOnlineHelpSupportedLangs().split(",")).filter(s -> StringUtil.isNotBlank(s)).anyMatch(s -> s.equals(lang));
    }

    String getSupportedUploadedJsExtentions();

    public default String[] getSupportedUploadedJsExtentionsAsArray() {
        return StreamUtil.of(getSupportedUploadedJsExtentions().split(",")).filter(s -> StringUtil.isNotBlank(s))
                .toArray(n -> new String[n]);
    }

    String getSupportedUploadedCssExtentions();

    public default String[] getSupportedUploadedCssExtentionsAsArray() {
        return StreamUtil.of(getSupportedUploadedCssExtentions().split(",")).filter(s -> StringUtil.isNotBlank(s))
                .toArray(n -> new String[n]);
    }

    String getSupportedUploadedMediaExtentions();

    public default String[] getSupportedUploadedMediaExtentionsAsArray() {
        return StreamUtil.of(getSupportedUploadedMediaExtentions().split(",")).filter(s -> StringUtil.isNotBlank(s))
                .toArray(n -> new String[n]);
    }

    String getJobTemplateTitleWeb();

    String getJobTemplateTitleFile();

    String getJobTemplateTitleData();

    public default String getJobTemplateTitle(String type) {
        if (Constants.WEB_CRAWLER_TYPE.equals(type)) {
            return getJobTemplateTitleWeb();
        } else if (Constants.FILE_CRAWLER_TYPE.equals(type)) {
            return getJobTemplateTitleFile();
        } else if (Constants.DATA_CRAWLER_TYPE.equals(type)) {
            return getJobTemplateTitleData();
        }
        return "None";
    }

}
