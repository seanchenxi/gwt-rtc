/*
 * Copyright 2013 Xi CHEN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.seanchenxi.gwt.webrtc.client;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayUtils;

/**
 * User: Xi
 */
public class Constraints extends Constraint {

    public static native Constraints create() /*-{
        return { mandatory:{}, optional:[] };
    }-*/;

    protected Constraints(){}

    public final void setMandatory(Constraint constraint){
        set("mandatory", constraint);
    }

    public final Constraint getMandatory(){
        Constraint mandatory = get("mandatory");
        if(mandatory == null){
            setMandatory(Constraint.create());
            mandatory = get("mandatory");
        }
        return mandatory;
    }

    public final void setOptional(Constraint[] constraint){
        set("optional", JsArrayUtils.readOnlyJsArray(constraint));
    }

    public final JsArray<Constraint> getOptional(){
        JsArray<Constraint> optional = get("optional");
        if(optional == null){
            setOptional(new Constraint[]{});
            optional = get("optional");
        }
        return optional;
    }
}
