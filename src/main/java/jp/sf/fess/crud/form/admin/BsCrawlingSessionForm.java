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

package jp.sf.fess.crud.form.admin;

import java.util.HashMap;
import java.util.Map;

import org.seasar.struts.annotation.DateType;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.LongType;
import org.seasar.struts.annotation.Maxbytelength;
import org.seasar.struts.annotation.Required;

public abstract class BsCrawlingSessionForm {
    @IntegerType
    public String pageNumber;

    public Map<String, String> searchParams = new HashMap<String, String>();

    @IntegerType
    public int crudMode;

    public String getCurrentPageNumber() {
        return pageNumber;
    }

    @Required(target = "confirmfromupdate,update,delete")
    @LongType
    public String id;

    @Required(target = "confirmfromupdate,update,delete")
    @Maxbytelength(maxbytelength = 20)
    public String sessionId;

    @Maxbytelength(maxbytelength = 20)
    public String name;

    @Required(target = "confirmfromupdate,update,delete")
    @DateType
    public String expiredTime;

    @Required(target = "confirmfromupdate,update,delete")
    @DateType
    public String createdTime;

    public void initialize() {

        id = null;
        sessionId = null;
        name = null;
        expiredTime = null;
        createdTime = null;

    }

}