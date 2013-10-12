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

package jp.sf.fess.db.cbean.cq.bs;

import java.util.Collection;

import jp.sf.fess.db.allcommon.DBMetaInstanceHandler;
import jp.sf.fess.db.cbean.BrowserTypeCB;
import jp.sf.fess.db.cbean.WebConfigToBrowserTypeMappingCB;
import jp.sf.fess.db.cbean.WebCrawlingConfigCB;
import jp.sf.fess.db.cbean.cq.BrowserTypeCQ;
import jp.sf.fess.db.cbean.cq.WebConfigToBrowserTypeMappingCQ;
import jp.sf.fess.db.cbean.cq.WebCrawlingConfigCQ;

import org.seasar.dbflute.cbean.AbstractConditionQuery;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.chelper.HpQDRFunction;
import org.seasar.dbflute.cbean.chelper.HpQDRSetupper;
import org.seasar.dbflute.cbean.chelper.HpSSQFunction;
import org.seasar.dbflute.cbean.chelper.HpSSQOption;
import org.seasar.dbflute.cbean.chelper.HpSSQSetupper;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.coption.RangeOfOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;

/**
 * The abstract condition-query of WEB_CONFIG_TO_BROWSER_TYPE_MAPPING.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsWebConfigToBrowserTypeMappingCQ extends
        AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsWebConfigToBrowserTypeMappingCQ(
            final ConditionQuery childQuery, final SqlClause sqlClause,
            final String aliasName, final int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    @Override
    public String getTableDbName() {
        return "WEB_CONFIG_TO_BROWSER_TYPE_MAPPING";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as equal. (NullAllowed: if null, no condition)
     */
    public void setId_Equal(final Long id) {
        doSetId_Equal(id);
    }

    protected void doSetId_Equal(final Long id) {
        regId(CK_EQ, id);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as notEqual. (NullAllowed: if null, no condition)
     */
    public void setId_NotEqual(final Long id) {
        doSetId_NotEqual(id);
    }

    protected void doSetId_NotEqual(final Long id) {
        regId(CK_NES, id);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterThan(final Long id) {
        regId(CK_GT, id);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessThan. (NullAllowed: if null, no condition)
     */
    public void setId_LessThan(final Long id) {
        regId(CK_LT, id);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setId_GreaterEqual(final Long id) {
        regId(CK_GE, id);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param id The value of id as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setId_LessEqual(final Long id) {
        regId(CK_LE, id);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of id. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of id. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setId_RangeOf(final Long minNumber, final Long maxNumber,
            final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueId(), "ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_InScope(final Collection<Long> idList) {
        doSetId_InScope(idList);
    }

    protected void doSetId_InScope(final Collection<Long> idList) {
        regINS(CK_INS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     * @param idList The collection of id as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setId_NotInScope(final Collection<Long> idList) {
        doSetId_NotInScope(idList);
    }

    protected void doSetId_NotInScope(final Collection<Long> idList) {
        regINS(CK_NINS, cTL(idList), getCValueId(), "ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNull() {
        regId(CK_ISN, DOBJ);
    }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setId_IsNotNull() {
        regId(CK_ISNN, DOBJ);
    }

    protected void regId(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueId(), "ID");
    }

    abstract protected ConditionValue getCValueId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as equal. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_Equal(final Long webConfigId) {
        doSetWebConfigId_Equal(webConfigId);
    }

    protected void doSetWebConfigId_Equal(final Long webConfigId) {
        regWebConfigId(CK_EQ, webConfigId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_NotEqual(final Long webConfigId) {
        doSetWebConfigId_NotEqual(webConfigId);
    }

    protected void doSetWebConfigId_NotEqual(final Long webConfigId) {
        regWebConfigId(CK_NES, webConfigId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_GreaterThan(final Long webConfigId) {
        regWebConfigId(CK_GT, webConfigId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_LessThan(final Long webConfigId) {
        regWebConfigId(CK_LT, webConfigId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_GreaterEqual(final Long webConfigId) {
        regWebConfigId(CK_GE, webConfigId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigId The value of webConfigId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setWebConfigId_LessEqual(final Long webConfigId) {
        regWebConfigId(CK_LE, webConfigId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param minNumber The min number of webConfigId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of webConfigId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setWebConfigId_RangeOf(final Long minNumber,
            final Long maxNumber, final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueWebConfigId(), "WEB_CONFIG_ID",
                rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigIdList The collection of webConfigId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWebConfigId_InScope(final Collection<Long> webConfigIdList) {
        doSetWebConfigId_InScope(webConfigIdList);
    }

    protected void doSetWebConfigId_InScope(
            final Collection<Long> webConfigIdList) {
        regINS(CK_INS, cTL(webConfigIdList), getCValueWebConfigId(),
                "WEB_CONFIG_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * WEB_CONFIG_ID: {IX, NotNull, BIGINT(19), FK to WEB_CRAWLING_CONFIG}
     * @param webConfigIdList The collection of webConfigId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWebConfigId_NotInScope(final Collection<Long> webConfigIdList) {
        doSetWebConfigId_NotInScope(webConfigIdList);
    }

    protected void doSetWebConfigId_NotInScope(
            final Collection<Long> webConfigIdList) {
        regINS(CK_NINS, cTL(webConfigIdList), getCValueWebConfigId(),
                "WEB_CONFIG_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select WEB_CONFIG_ID from WEB_CRAWLING_CONFIG where ...)} <br />
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @param subQuery The sub-query of WebCrawlingConfig for 'in-scope'. (NotNull)
     */
    public void inScopeWebCrawlingConfig(
            final SubQuery<WebCrawlingConfigCB> subQuery) {
        assertObjectNotNull("subQuery<WebCrawlingConfigCB>", subQuery);
        final WebCrawlingConfigCB cb = new WebCrawlingConfigCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepWebConfigId_InScopeRelation_WebCrawlingConfig(cb
                .query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "WEB_CONFIG_ID", "ID",
                subQueryPropertyName, "webCrawlingConfig");
    }

    public abstract String keepWebConfigId_InScopeRelation_WebCrawlingConfig(
            WebCrawlingConfigCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select WEB_CONFIG_ID from WEB_CRAWLING_CONFIG where ...)} <br />
     * WEB_CRAWLING_CONFIG by my WEB_CONFIG_ID, named 'webCrawlingConfig'.
     * @param subQuery The sub-query of WebCrawlingConfig for 'not in-scope'. (NotNull)
     */
    public void notInScopeWebCrawlingConfig(
            final SubQuery<WebCrawlingConfigCB> subQuery) {
        assertObjectNotNull("subQuery<WebCrawlingConfigCB>", subQuery);
        final WebCrawlingConfigCB cb = new WebCrawlingConfigCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepWebConfigId_NotInScopeRelation_WebCrawlingConfig(cb
                .query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "WEB_CONFIG_ID", "ID",
                subQueryPropertyName, "webCrawlingConfig");
    }

    public abstract String keepWebConfigId_NotInScopeRelation_WebCrawlingConfig(
            WebCrawlingConfigCQ subQuery);

    protected void regWebConfigId(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueWebConfigId(), "WEB_CONFIG_ID");
    }

    abstract protected ConditionValue getCValueWebConfigId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as equal. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_Equal(final Long browserTypeId) {
        doSetBrowserTypeId_Equal(browserTypeId);
    }

    protected void doSetBrowserTypeId_Equal(final Long browserTypeId) {
        regBrowserTypeId(CK_EQ, browserTypeId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_NotEqual(final Long browserTypeId) {
        doSetBrowserTypeId_NotEqual(browserTypeId);
    }

    protected void doSetBrowserTypeId_NotEqual(final Long browserTypeId) {
        regBrowserTypeId(CK_NES, browserTypeId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_GreaterThan(final Long browserTypeId) {
        regBrowserTypeId(CK_GT, browserTypeId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_LessThan(final Long browserTypeId) {
        regBrowserTypeId(CK_LT, browserTypeId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_GreaterEqual(final Long browserTypeId) {
        regBrowserTypeId(CK_GE, browserTypeId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeId The value of browserTypeId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setBrowserTypeId_LessEqual(final Long browserTypeId) {
        regBrowserTypeId(CK_LE, browserTypeId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param minNumber The min number of browserTypeId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of browserTypeId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setBrowserTypeId_RangeOf(final Long minNumber,
            final Long maxNumber, final RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueBrowserTypeId(),
                "BROWSER_TYPE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeIdList The collection of browserTypeId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBrowserTypeId_InScope(
            final Collection<Long> browserTypeIdList) {
        doSetBrowserTypeId_InScope(browserTypeIdList);
    }

    protected void doSetBrowserTypeId_InScope(
            final Collection<Long> browserTypeIdList) {
        regINS(CK_INS, cTL(browserTypeIdList), getCValueBrowserTypeId(),
                "BROWSER_TYPE_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * BROWSER_TYPE_ID: {IX, NotNull, BIGINT(19), FK to BROWSER_TYPE}
     * @param browserTypeIdList The collection of browserTypeId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBrowserTypeId_NotInScope(
            final Collection<Long> browserTypeIdList) {
        doSetBrowserTypeId_NotInScope(browserTypeIdList);
    }

    protected void doSetBrowserTypeId_NotInScope(
            final Collection<Long> browserTypeIdList) {
        regINS(CK_NINS, cTL(browserTypeIdList), getCValueBrowserTypeId(),
                "BROWSER_TYPE_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select BROWSER_TYPE_ID from BROWSER_TYPE where ...)} <br />
     * BROWSER_TYPE by my BROWSER_TYPE_ID, named 'browserType'.
     * @param subQuery The sub-query of BrowserType for 'in-scope'. (NotNull)
     */
    public void inScopeBrowserType(final SubQuery<BrowserTypeCB> subQuery) {
        assertObjectNotNull("subQuery<BrowserTypeCB>", subQuery);
        final BrowserTypeCB cb = new BrowserTypeCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepBrowserTypeId_InScopeRelation_BrowserType(cb
                .query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "BROWSER_TYPE_ID", "ID",
                subQueryPropertyName, "browserType");
    }

    public abstract String keepBrowserTypeId_InScopeRelation_BrowserType(
            BrowserTypeCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select BROWSER_TYPE_ID from BROWSER_TYPE where ...)} <br />
     * BROWSER_TYPE by my BROWSER_TYPE_ID, named 'browserType'.
     * @param subQuery The sub-query of BrowserType for 'not in-scope'. (NotNull)
     */
    public void notInScopeBrowserType(final SubQuery<BrowserTypeCB> subQuery) {
        assertObjectNotNull("subQuery<BrowserTypeCB>", subQuery);
        final BrowserTypeCB cb = new BrowserTypeCB();
        cb.xsetupForInScopeRelation(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepBrowserTypeId_NotInScopeRelation_BrowserType(cb
                .query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "BROWSER_TYPE_ID", "ID",
                subQueryPropertyName, "browserType");
    }

    public abstract String keepBrowserTypeId_NotInScopeRelation_BrowserType(
            BrowserTypeCQ subQuery);

    protected void regBrowserTypeId(final ConditionKey k, final Object v) {
        regQ(k, v, getCValueBrowserTypeId(), "BROWSER_TYPE_ID");
    }

    abstract protected ConditionValue getCValueBrowserTypeId();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand());
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;WebConfigToBrowserTypeMappingCB&gt;() {
     *     public void query(WebConfigToBrowserTypeMappingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WebConfigToBrowserTypeMappingCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand());
    }

    protected HpSSQFunction<WebConfigToBrowserTypeMappingCB> xcreateSSQFunction(
            final String operand) {
        return new HpSSQFunction<WebConfigToBrowserTypeMappingCB>(
                new HpSSQSetupper<WebConfigToBrowserTypeMappingCB>() {
                    @Override
                    public void setup(
                            final String function,
                            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery,
                            final HpSSQOption<WebConfigToBrowserTypeMappingCB> option) {
                        xscalarCondition(function, subQuery, operand, option);
                    }
                });
    }

    protected void xscalarCondition(final String function,
            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery,
            final String operand,
            final HpSSQOption<WebConfigToBrowserTypeMappingCB> option) {
        assertObjectNotNull("subQuery<WebConfigToBrowserTypeMappingCB>",
                subQuery);
        final WebConfigToBrowserTypeMappingCB cb = xcreateScalarConditionCB();
        subQuery.query(cb);
        final String subQueryPropertyName = keepScalarCondition(cb.query()); // for saving query-value
        option.setPartitionByCBean(xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(function, cb.query(), subQueryPropertyName,
                operand, option);
    }

    public abstract String keepScalarCondition(
            WebConfigToBrowserTypeMappingCQ subQuery);

    protected WebConfigToBrowserTypeMappingCB xcreateScalarConditionCB() {
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected WebConfigToBrowserTypeMappingCB xcreateScalarConditionPartitionByCB() {
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(final String function,
            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery,
            final String aliasName, final DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<WebConfigToBrowserTypeMappingCB>",
                subQuery);
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForDerivedReferrer(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(function, cb.query(), "ID", "ID",
                subQueryPropertyName, "myselfDerived", aliasName, option);
    }

    public abstract String keepSpecifyMyselfDerived(
            WebConfigToBrowserTypeMappingCQ subQuery);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<WebConfigToBrowserTypeMappingCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived();
    }

    protected HpQDRFunction<WebConfigToBrowserTypeMappingCB> xcreateQDRFunctionMyselfDerived() {
        return new HpQDRFunction<WebConfigToBrowserTypeMappingCB>(
                new HpQDRSetupper<WebConfigToBrowserTypeMappingCB>() {
                    @Override
                    public void setup(
                            final String function,
                            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery,
                            final String operand, final Object value,
                            final DerivedReferrerOption option) {
                        xqderiveMyselfDerived(function, subQuery, operand,
                                value, option);
                    }
                });
    }

    public void xqderiveMyselfDerived(final String function,
            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery,
            final String operand, final Object value,
            final DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<WebConfigToBrowserTypeMappingCB>",
                subQuery);
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForDerivedReferrer(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        final String parameterPropertyName = keepQueryMyselfDerivedParameter(value);
        registerQueryMyselfDerived(function, cb.query(), "ID", "ID",
                subQueryPropertyName, "myselfDerived", operand, value,
                parameterPropertyName, option);
    }

    public abstract String keepQueryMyselfDerived(
            WebConfigToBrowserTypeMappingCQ subQuery);

    public abstract String keepQueryMyselfDerivedParameter(Object parameterValue);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(
            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery) {
        assertObjectNotNull("subQuery<WebConfigToBrowserTypeMappingCB>",
                subQuery);
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForMyselfExists(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), subQueryPropertyName);
    }

    public abstract String keepMyselfExists(
            WebConfigToBrowserTypeMappingCQ subQuery);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(
            final SubQuery<WebConfigToBrowserTypeMappingCB> subQuery) {
        assertObjectNotNull("subQuery<WebConfigToBrowserTypeMappingCB>",
                subQuery);
        final WebConfigToBrowserTypeMappingCB cb = new WebConfigToBrowserTypeMappingCB();
        cb.xsetupForMyselfInScope(this);
        subQuery.query(cb);
        final String subQueryPropertyName = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), subQueryPropertyName);
    }

    public abstract String keepMyselfInScope(
            WebConfigToBrowserTypeMappingCQ subQuery);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCB() {
        return WebConfigToBrowserTypeMappingCB.class.getName();
    }

    protected String xabCQ() {
        return WebConfigToBrowserTypeMappingCQ.class.getName();
    }

    protected String xabLSO() {
        return LikeSearchOption.class.getName();
    }

    protected String xabSSQS() {
        return HpSSQSetupper.class.getName();
    }
}