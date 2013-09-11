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
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.seanchenxi.gwt.file.client.Blob;

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#datachannel
 */
public final class DataChannelNative extends JavaScriptObject {

    protected DataChannelNative(){
    }

    static native boolean is(JavaScriptObject jso) /*-{
        return jso && jso.label && jso.readyState;
    }-*/;

    native String getLabel() /*-{
        return this.label;
    }-*/;

    native boolean isReliable() /*-{
        return this.reliable;
    }-*/;

    native String getReadyStateNative() /*-{
        return this.readyState;
    }-*/;

    native int getBufferedAmount() /*-{
        return this.bufferedAmount;
    }-*/;

    native String getBinaryType() /*-{
        return this.binaryType;
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
