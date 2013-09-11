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

import com.google.gwt.dom.client.EventTarget;

/**
 * User: Xi
 */
public class FileReaderNative extends EventTarget {

    protected FileReaderNative() {
    }

    static final native FileReaderNative create() /*-{
        return new FileReader();
    }-*/;

    final native void abort() /*-{
        this.abort();
    }-*/;

    final native void readAsArrayBuffer(Blob blob) /*-{
        this.readAsArrayBuffer(blob);
    }-*/;

    final native void readAsBinaryString(Blob blob) /*-{
        this.readAsBinaryString(blob);
    }-*/;

    final native void readAsDataURL(Blob blob) /*-{
        this.readAsDataURL(blob);
    }-*/;

    final native void readAsText(Blob blob, String encoding) /*-{
        this.readAsText(blob, encoding);
    }-*/;

    final native int getReadyState() /*-{
        return this.readyState;
    }-*/;

    final native FileError getFileError() /*-{
        return this.error;
    }-*/;

    final native Object getResult() /*-{
        return this.result;
    }-*/;
}
