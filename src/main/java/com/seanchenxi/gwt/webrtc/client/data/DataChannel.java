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
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.seanchenxi.gwt.file.client.Blob;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.webrtc.client.event.CloseEvent;
import com.seanchenxi.gwt.webrtc.client.event.ErrorEvent;
import com.seanchenxi.gwt.webrtc.client.event.MessageEvent;
import com.seanchenxi.gwt.webrtc.client.event.OpenEvent;

/**
 * User: Xi
 */
public class DataChannel extends FNObject {

    private final DataChannelNative impl;

    protected DataChannel(DataChannelNative impl){
        this.impl = impl;
    }

    public static DataChannel as(JavaScriptObject jso) {
        assert is(jso);
        return new DataChannel(jso.<DataChannelNative>cast());
    }

    public static boolean is(JavaScriptObject jso){
        return DataChannelNative.is(jso);
    }

    public final DataChannelState getReadyState(){
        return DataChannelState.parseValue(impl.getReadyStateNative());
    }

    public boolean isReliable() {
        return impl.isReliable();
    }

    public void send(ArrayBufferView data) {
        impl.send(data);
    }

    public int getBufferedAmount() {
        return impl.getBufferedAmount();
    }

    public void send(String data) {
        impl.send(data);
    }

    public String getBinaryType() {
        return impl.getBinaryType();
    }

    public void send(Blob data) {
        impl.send(data);
    }

    public String getLabel() {
        return impl.getLabel();
    }

    public void send(ArrayBuffer data) {
        impl.send(data);
    }

    public HandlerRegistration addOpenHandler(OpenEvent.Handler handler){
        return addFnEventHandler(OpenEvent.getType(), handler);
    }

    public HandlerRegistration addMessageHandler(MessageEvent.Handler handler){
        return addFnEventHandler(MessageEvent.getType(), handler);
    }

    public HandlerRegistration addErrorHandler(ErrorEvent.Handler<NativeEvent> handler){
        return addFnEventHandler(ErrorEvent.getType(), handler);
    }

    public HandlerRegistration addCloseHandler(CloseEvent.Handler handler){
        return addFnEventHandler(CloseEvent.getType(), handler);
    }

    @Override
    public DataChannelNative asNative() {
        return impl;
    }
}
