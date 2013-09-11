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

package com.seanchenxi.gwt.webrtc.client.connection;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.EventTarget;
import com.seanchenxi.gwt.webrtc.client.Constraints;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelNative;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelInit;
import com.seanchenxi.gwt.webrtc.client.media.MediaStreamNative;

/**
 * User : Xi
 * @see : http://www.w3.org/TR/webrtc/#rtcpeerconnection-interface
 */
public final class RTCPeerConnectionNative extends EventTarget {

    protected RTCPeerConnectionNative() {

    }

    static native boolean is(JavaScriptObject jso) /*-{
        return true;   //TODO
    }-*/;

    native void createOffer(RTCSessionDescriptionCallback callback, Constraints constraints) /*-{
        this.createOffer(
            $entry(
                callback.@com.seanchenxi.gwt.webrtc.client.connection.RTCSessionDescriptionCallback::onSuccess(Lcom/seanchenxi/gwt/webrtc/client/connection/RTCSessionDescription;).bind(callback)
            ),
            $entry(
                callback.@com.seanchenxi.gwt.webrtc.client.connection.RTCSessionDescriptionCallback::onError(Ljava/lang/String;).bind(callback)
            ),
            constraints);
    }-*/;

    native void createAnswer(RTCSessionDescriptionCallback callback, Constraints constraints) /*-{
        this.createAnswer(
            $entry(
                callback.@com.seanchenxi.gwt.webrtc.client.connection.RTCSessionDescriptionCallback::onSuccess(Lcom/seanchenxi/gwt/webrtc/client/connection/RTCSessionDescription;).bind(callback)
            ),
            $entry(
                callback.@com.seanchenxi.gwt.webrtc.client.connection.RTCSessionDescriptionCallback::onError(Ljava/lang/String;).bind(callback)
            ),
            constraints);
    }-*/;

    native RTCSessionDescription getLocalDescription() /*-{
        return this.localDescription;
    }-*/;

    native void setLocalDescription(RTCSessionDescription sessionDescription) /*-{
        this.setLocalDescription(sessionDescription);
    }-*/;

    native RTCSessionDescription getRemoteDescription() /*-{
        return this.remoteDescription;
    }-*/;

    native void setRemoteDescription(RTCSessionDescription sessionDescription) /*-{
        this.setRemoteDescription(sessionDescription);
    }-*/;

    native String getReadyStateNative()/*-{
        return this.readyState;
    }-*/;

    native void updateIce(RTCConfiguration configuration, Constraints constraints, boolean restart)/*-{
        return this.updateIce(configuration, constraints, restart);
    }-*/;

    native void addIceCandidate(RTCIceCandidate iceCandidate) /*-{
        this.addIceCandidate(iceCandidate);
    }-*/;

    native String getIceStateNative() /*-{
        return this.iceState;
    }-*/;

    native JsArray<MediaStreamNative> getLocalStreams()/*-{
        return this.localStreams;
    }-*/;

    native JsArray<MediaStreamNative> getRemoteStreams()/*-{
        return this.remoteStreams;
    }-*/;

    native DataChannelNative createDataChannel(String label) /*-{
        return this.createDataChannel(label);
    }-*/;

    native DataChannelNative createDataChannel(String label, DataChannelInit dataChannelDict) /*-{
        return this.createDataChannel(label, dataChannelDict);
    }-*/;

    native void addStream(MediaStreamNative stream, Constraints constraints) /*-{
        this.addStream(stream, constraints);
    }-*/;

    native void addStream(MediaStreamNative stream) /*-{
        this.addStream(stream);
    }-*/;
    
    native void removeStream(MediaStreamNative stream) /*-{
        this.removeStream(stream);
    }-*/;

    native void close() /*-{
        this.close();
    }-*/;
}
