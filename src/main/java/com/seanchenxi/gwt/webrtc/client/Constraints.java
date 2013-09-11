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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * User: Xi
 */
public class Constraints extends JavaScriptObject {

    protected Constraints(){}

    public final native void setConstraint(String name, boolean enable) /*-{
        this[name] = enable;    
    }-*/; 
  
    public final native JsArray<Constraint> getOptionalConstraints() /*-{
        if(typeof this.optional === 'undefined'){
            this.optional = [];
        }
        return this.optional;
    }-*/;

    public final native void addOptionalConstraint(Constraint constraint) /*-{
        if(typeof this.optional === 'undefined'){
            this.optional = [];
        }
        this.optional.push(constraint);
    }-*/;

    public final native void addOptionalConstraint(String name, boolean enable) /*-{
        if(typeof this.optional === 'undefined'){
            this.optional = [];
        }
        var constraint = {};
        constraint[name] = enable;
        this.optional.push(constraint);
    }-*/;

    public final native Constraint getMandatoryConstraints() /*-{
        if(typeof this.mandatory === 'undefined'){
            this.mandatory = {};
        }
        return this.mandatory;
    }-*/;

    public final native void setMandatoryConstraint(String name, boolean enable) /*-{
        if(typeof this.mandatory === 'undefined'){
            this.mandatory = {};
        }
        this.mandatory[name] = enable;
    }-*/;

}
