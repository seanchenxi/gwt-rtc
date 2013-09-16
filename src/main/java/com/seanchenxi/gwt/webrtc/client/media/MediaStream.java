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
import com.google.gwt.event.shared.HandlerRegistration;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.html.client.event.AddTrackEvent;
import com.seanchenxi.gwt.html.client.event.EndedEvent;
import com.seanchenxi.gwt.html.client.event.RemoveTrackEvent;

/**
 * User: Xi
 */
public class MediaStream extends FNObject {

    private final MediaStreamNative impl;

    protected MediaStream(MediaStreamNative impl) {
        this.impl = impl;
    }

    public static MediaStream as(JavaScriptObject jso) {
        assert is(jso);
        return new MediaStream(jso.<MediaStreamNative>cast());
    }

    public static final native boolean is(JavaScriptObject jso) /*-{
        return true;  //TODO
    }-*/;

    public String getId() {
        return impl.getId();
    }

    public MediaStreamTrackList getAudioTracks() {
        return impl.getAudioTracks();
    }

    public boolean isEnded() {
        return impl.isEnded();
    }

    public MediaStreamTrackList getVideoTracks() {
        return impl.getVideoTracks();
    }

    public void removeTrack(MediaStreamTrack track) {
        impl.removeTrack(track);
    }

    public void addTrack(MediaStreamTrack track) {
        impl.addTrack(track);
    }

    public MediaStream clone() {
        return MediaStream.as(impl.clone());
    }

    public HandlerRegistration addEndedHandler(EndedEvent.Handler handler) {
        return addFnEventHandler(EndedEvent.getType(), handler);
    }

    public HandlerRegistration addAddTrackHandler(AddTrackEvent.Handler handler) {
        return addFnEventHandler(AddTrackEvent.getType(), handler);
    }

    public HandlerRegistration addRemoveTrackHandler(RemoveTrackEvent.Handler handler) {
        return addFnEventHandler(RemoveTrackEvent.getType(), handler);
    }

    @Override
    public MediaStreamNative asNative() {
        return impl;
    }
}
