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

package com.seanchenxi.gwt.webrtc.client.connection;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#idl-def-RTCIceServer
 */
public class RTCIceServer extends JavaScriptObject {

    protected RTCIceServer() {
    }

    public final native String getUrl() /*-{
        return this.url;
    }-*/;

    public final native void setUrl(String url) /*-{
        this.url = url;
    }-*/;

    public final native String getCredential() /*-{
        return this.credential;
    }-*/;

    public final native void setCredential(String credential) /*-{
        this.credential = credential;
    }-*/;
    
    public final native String getUserName() /*-{
        return this.username;    
    }-*/;

    public final native void setUserName(String userName) /*-{
        this.username = userName;
    }-*/;
}