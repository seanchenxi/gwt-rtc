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

package com.seanchenxi.gwt.file.client;

import com.google.gwt.event.shared.HandlerRegistration;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.html.client.event.*;

/**
 * User: Xi
 */
public final class FileReader extends FNObject {

    public enum State {

        EMPTY(0), LOADING(1), DONE(2);

        private final int value;

        private State(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }

        public static State parseValue(int value){
            for(State frs : values()){
                if(frs.value == value){
                    return frs;
                }
            }
            return EMPTY;
        }
    }

    private final FileReaderNative impl;

    public FileReader() {
        impl = FileReaderNative.create();
    }

    public void readAsBinaryString(Blob blob) {
        impl.readAsBinaryString(blob);
    }

    public State getReadyState() {
        return State.parseValue(impl.getReadyState());
    }

    public void abort() {
        impl.abort();
    }

    public Object getResult() {
        return impl.getResult();
    }

    public FileError getFileError() {
        return impl.getFileError();
    }

    public void readAsDataURL(Blob blob) {
        impl.readAsDataURL(blob);
    }

    public void readAsText(Blob blob, String encoding) {
        impl.readAsText(blob, encoding);
    }

    public void readAsArrayBuffer(Blob blob) {
        impl.readAsArrayBuffer(blob);
    }

    public HandlerRegistration addAbortHandler(AbortEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(AbortEvent.<ProgressEventNative>getType(), handler);
    }

    public HandlerRegistration addErrorHandler(ErrorEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(ErrorEvent.<ProgressEventNative>getType(), handler);
    }

    public HandlerRegistration addLoadHandler(LoadEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(LoadEvent.<ProgressEventNative>getType(), handler);
    }

    public HandlerRegistration addLoadEndHandler(LoadEndEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(LoadEndEvent.<ProgressEventNative>getType(), handler);
    }

    public HandlerRegistration addLoadStartHandler(LoadStartEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(LoadStartEvent.<ProgressEventNative>getType(), handler);
    }

    public HandlerRegistration addProgressHandler(ProgressEvent.Handler<ProgressEventNative> handler){
        return addFnEventHandler(ProgressEvent.<ProgressEventNative>getType(), handler);
    }

    @Override
    public FileReaderNative asNative() {
        return impl;
    }
}
