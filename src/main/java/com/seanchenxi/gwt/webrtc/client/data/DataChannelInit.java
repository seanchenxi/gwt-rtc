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

package com.seanchenxi.gwt.webrtc.client.data;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#idl-def-DataChannelInit
 */
public final class DataChannelInit extends JavaScriptObject {

    protected DataChannelInit(){
    }

    public native boolean isReliable() /*-{
        return this.reliable;
    }-*/;

    public native void setReliable(boolean reliable) /*-{
        this.reliable = reliable;
    }-*/;
}
