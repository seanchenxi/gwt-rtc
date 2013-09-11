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

import com.google.gwt.dom.client.EventTarget;

/**
 * User: Xi
 * @see: http://dev.w3.org/2011/webrtc/editor/getusermedia.html#idl-def-MediaStreamTrack
 */
public class MediaStreamTrack extends EventTarget {

    protected MediaStreamTrack() {
    }

    public final native String getKind() /*-{
        return this.kind;
    }-*/;

    public final native String getId() /*-{
        return this.id;
    }-*/;

    public final native String getLabel() /*-{
        return this.label;
    }-*/;

    public final native boolean isEnabled() /*-{
        return this.enabled;
    }-*/;

    public final native void setEnabled(boolean enabled) /*-{
        this.enabled = enabled;
    }-*/;

    public final native boolean isMuted() /*-{
        return this.muted;
    }-*/;

    public final native boolean isReadOnly() /*-{
        return this._readonly;
    }-*/;

    public final native boolean isRemote() /*-{
        return this.remote;
    }-*/;

    public final MediaStreamTrackState getReadyState(){
        return MediaStreamTrackState.parseValue(getReadyStateNative());
    }

    private native String getReadyStateNative() /*-{
        return this.readyState;
    }-*/;

    public final native SourceInfoList getSourceInfos() /*-{
        return this.getSourceInfos();
    }-*/;

    public final native void stop() /*-{
        return this.stop();
    }-*/;

    public final native MediaStreamTrack clone() /*-{
        return this.clone();
    }-*/;
}

