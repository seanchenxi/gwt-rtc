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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.typedarrays.shared.ArrayBuffer;
import com.google.gwt.typedarrays.shared.ArrayBufferView;

/**
 * User: Xi
 */
public class BlobNative extends JavaScriptObject implements Blob {

    public static final native BlobNative create()/*-{
        return new Blob();
    }-*/;

    public static final native BlobNative create(ArrayBufferView arrayBufferView)/*-{
        return new Blob(arrayBufferView);
    }-*/;

    public static final native BlobNative create(ArrayBuffer arrayBuffer)/*-{
        return new Blob(arrayBuffer);
    }-*/;

    public static final native BlobNative create(Blob blob)/*-{
        return new Blob(blob);
    }-*/;

    public static final native BlobNative create(String string)/*-{
        return new Blob(string);
    }-*/;

    protected BlobNative(){}

    @Override
    public final native double getSize() /*-{
        return this.size;
    }-*/;

    @Override
    public final native String getType() /*-{
        return this.type;
    }-*/;

    @Override
    public final native BlobNative slice() /*-{
        return this.slice();
    }-*/;

    @Override
    public final native BlobNative slice(double start) /*-{
        return this.slice(start);
    }-*/;

    @Override
    public final native BlobNative slice(double start, double end) /*-{
        return this.slice(start, end);
    }-*/;

    @Override
    public final native BlobNative slice(double start, double end, String contentType) /*-{
        return this.slice(start, end, contentType);
    }-*/;

    @Override
    public final native void close() /*-{
        return this.close();
    }-*/;
}
