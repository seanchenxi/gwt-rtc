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

package com.seanchenxi.gwt.webrtc.client.media;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * User: Xi
 * @see: http://dev.w3.org/2011/webrtc/editor/getusermedia.html#idl-def-SourceInfo
 */
public class SourceInfo extends JavaScriptObject {

    protected SourceInfo() {
    }

    public final native String getSourceId() /*-{
        return this.sourceId;
    }-*/;

    public final native void setSourceId(String sourceId) /*-{
        this.sourceId = sourceId;
    }-*/;

    public final native String getKind() /*-{
        return this.kind;
    }-*/;

    public final native void setKind(String kind) /*-{
        this.kind = kind;
    }-*/;

    public final native String getLabel() /*-{
        return this.label;
    }-*/;

    public final native void setLabel(String label) /*-{
        this.label = label;
    }-*/;

}
