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
public class Constraint extends JavaScriptObject {

    public static Constraint create(){
        return JavaScriptObject.createObject().cast();
    }

    protected Constraint() {
    }

    public final native void set(String name, boolean enable)/*-{
        this[name] = enable;
    }-*/;

    public final native void set(String name, int number)/*-{
        this[name] = number;
    }-*/;

    public final native void set(String name, String str)/*-{
        this[name] = str;
    }-*/;

    public final native void set(String name, Constraint constraint)/*-{
        this[name] = constraint;
    }-*/;

    public final native void set(String name, JsArray<Constraint> constraints)/*-{
        this[name] = constraints;
    }-*/;

    public final native <T> T get(String name)/*-{
        return this[name];
    }-*/;
}
