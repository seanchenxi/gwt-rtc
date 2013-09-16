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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;
import com.seanchenxi.gwt.file.client.Blob;
import com.seanchenxi.gwt.html.client.BinaryType;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.html.client.event.CloseEvent;
import com.seanchenxi.gwt.html.client.event.ErrorEvent;
import com.seanchenxi.gwt.html.client.event.MessageEvent;
import com.seanchenxi.gwt.html.client.event.OpenEvent;

/**
 * User: Xi
 */
public final class WebSocket extends FNObject {

    public enum ReadyState {

        CONNECTING(0), OPEN(1), CLOSING(2), CLOSED(3);

        private final int value;

        private ReadyState(int value) {
            this.value = value;
        }

        public static ReadyState parseValue(int value) {
            for (ReadyState rs : values()) {
                if (rs.value == value) {
                    return rs;
                }
            }
            return null;
        }

    }

    private final WebSocketNative impl;

    public WebSocket(String url, String... protocols) {
        impl = WebSocketNative.create(url, protocols);
    }

    public WebSocket(String url) {
        impl = WebSocketNative.create(url);
    }

    public ReadyState getReadyState() {
        return ReadyState.parseValue(impl.getReadyState());
    }

    public double getBufferedAmount() {
        return impl.getBufferedAmount();
    }

    public String getExtensions() {
        return impl.getExtensions();
    }

    public String getProtocol() {
        return impl.getProtocol();
    }

    public BinaryType getBinaryType() {
        return BinaryType.parseValue(impl.getBinaryType());
    }

    public void close() {
        impl.close();
    }

    public void close(int code) {
        impl.close(code);
    }

    public void close(int code, String reason) {
        impl.close(code, reason);
    }

    public void send(String data) {
        impl.send(data);
    }

    public void send(Blob data) {
        impl.send(data);
    }

    public void send(ArrayBuffer data) {
        impl.send(data);
    }

    public void send(ArrayBufferView data) {
        impl.send(data);
    }

    public HandlerRegistration addOpenHandler(OpenEvent.Handler handler){
        return addFnEventHandler(OpenEvent.getType(), handler);
    }

    public HandlerRegistration addCloseHandler(CloseEvent.Handler handler){
        return addFnEventHandler(CloseEvent.getType(), handler);
    }

    public HandlerRegistration addErrorHandler(ErrorEvent.Handler<NativeEvent> handler){
        return addFnEventHandler(ErrorEvent.getType(), handler);
    }

    public HandlerRegistration addMessageHandler(MessageEvent.Handler handler){
        return addFnEventHandler(MessageEvent.getType(), handler);
    }
    
    @Override
    public JavaScriptObject asNative() {
        return impl;
    }
}
