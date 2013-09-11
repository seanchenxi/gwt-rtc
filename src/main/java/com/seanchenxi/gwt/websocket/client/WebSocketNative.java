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

package com.seanchenxi.gwt.websocket.client;

import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.seanchenxi.gwt.file.client.Blob;

/**
 * User : Xi
 * @see : http://www.w3.org/TR/websockets/
 */
final class WebSocketNative extends EventTarget {

    static native WebSocketNative create(String url, String[] protocols) /*-{
        return new WebSocket(url, protocols);
    }-*/;

    static native WebSocketNative create(String url) /*-{
        return new WebSocket(url);
    }-*/;

    protected WebSocketNative(){
    }

    native double getBufferedAmount() /*-{
        return this.bufferedAmount;
    }-*/;

    native String getExtensions()  /*-{
        return this.extensions;
    }-*/;

    native String getProtocol()  /*-{
        return this.protocol;
    }-*/;

    native String getBinaryType()  /*-{
        return this.binaryType;
    }-*/;

    native int getReadyState() /*-{
        return this.readyState;
    }-*/;

    native String getUrl() /*-{
        return this.url;
    }-*/;

    native void close() /*-{
        this.close();
    }-*/;

    native void close(int code) /*-{
        this.close(code);
    }-*/;

    native void close(int code, String reason) /*-{
        this.close(code, reason);
    }-*/;

    native void send(String data) /*-{
        this.send(data);
    }-*/;

    native void send(Blob data) /*-{
        this.send(data);
    }-*/;

    native void send(ArrayBuffer data) /*-{
        this.send(data);
    }-*/;

    native void send(ArrayBufferView data) /*-{
        this.send(data);
    }-*/;

}
