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

package com.seanchenxi.gwt.html.client;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * User: Xi
 */
public enum BinaryType {
    TEXT(""), BLOB("blob"), ARRAY_BUFFER("arraybuffer"), ARRAY_BUFFER_VIEW("arraybufferview");

    private final String value;

    private BinaryType(String value){
        this.value = value;
    }

    public static BinaryType parseValue(String value){
        for(BinaryType bt : values()){
            if(bt.value.equalsIgnoreCase(value)){
                return bt;
            }
        }
        return TEXT;
    }

    public static final BinaryType findType(Object value){
        if(value instanceof String){
            return BinaryType.TEXT;   
        }
        return parseValue(findTypeNative((JavaScriptObject)value));
    }

    public static final native String findTypeNative(JavaScriptObject value) /*-{
        if(value instanceof ArrayBufferView){
            return "arraybufferview";
        }else if(value instanceof ArrayBuffer){
            return "arraybuffer";
        }else if(value instanceof Blob){
            return "blob";
        }else if(value instanceof String){
            return "";
        }
        return "";
    }-*/;

}
