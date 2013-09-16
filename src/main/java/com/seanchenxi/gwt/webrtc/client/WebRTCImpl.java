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

package com.seanchenxi.gwt.webrtc.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.seanchenxi.gwt.webrtc.client.connection.*;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelInit;
import com.seanchenxi.gwt.webrtc.client.media.MediaStream;
import com.seanchenxi.gwt.webrtc.client.media.MediaStreamNative;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaCallback;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaConstraints;

/**
 * User: Xi
 */
public abstract class WebRTCImpl {

    protected static void handleUserMediaCallback(UserMediaCallback callback, MediaStreamNative localMediaStream, String error) {
        if ((error != null && !error.trim().isEmpty()) || localMediaStream == null) {
            callback.onError(error);
        } else {
            callback.onSuccess(MediaStream.as(localMediaStream));
        }
    }

    public RTCPeerConnectionNative createRTCPeerConnectionNative(RTCConfiguration configuration) {
        return createRTCPeerConnectionNative(configuration, null);
    }

    public final native RTCSessionDescriptionInit createRTCSessionDescriptionInit(RTCSdpType type, String sdp) /*-{
        return {
            type: type.@com.seanchenxi.gwt.webrtc.client.connection.RTCSdpType::getValue()(), sdp: sdp
        };
    }-*/;

    public final native RTCIceCandidateInit createRTCIceCandidateInit(String candidate, String sdpMid, int sdpMLineIndex) /*-{
        return {
            candidate: candidate, sdpMid: sdpMid, sdpMLineIndex: sdpMLineIndex
        };
    }-*/;

    public final native boolean isMobile()/*-{
        if( navigator.userAgent.match(/Android/i)
            || navigator.userAgent.match(/webOS/i)
            || navigator.userAgent.match(/iPhone/i)
            || navigator.userAgent.match(/iPad/i)
            || navigator.userAgent.match(/iPod/i)
            || navigator.userAgent.match(/BlackBerry/i)
            || navigator.userAgent.match(/Windows Phone/i)
            ){
            return true;
        }else {
            return false;
        }
    }-*/;

    public final DataChannelInit createDataChannelInit(boolean reliable) {
        DataChannelInit init = JavaScriptObject.createObject().cast();
        init.setReliable(reliable);
        return init;
    }

    public final RTCIceServer createRTCIceServer(String url, String credential) {
        RTCIceServer server = JavaScriptObject.createObject().cast();
        server.setUrl(url);
        if (credential != null && !credential.trim().isEmpty())
            server.setCredential(credential);
        return server;
    }

    public final RTCConfiguration createRTCConfiguration(JsArray<RTCIceServer> iceServers) {
        RTCConfiguration config = JavaScriptObject.createObject().cast();
        config.setIceServers(iceServers);
        return config;
    }

    public abstract boolean isGecko();

    public abstract boolean isWebkit();

    public abstract void getUserMedia(UserMediaConstraints constraints, UserMediaCallback callback);

    public abstract RTCPeerConnectionNative createRTCPeerConnectionNative(RTCConfiguration configuration, Constraints constraints);

    public abstract RTCSessionDescription createRTCSessionDescription(RTCSessionDescriptionInit init);

    public abstract RTCIceCandidate createRTCIceCandidate(RTCIceCandidateInit candidateInitDict);

    public abstract String createObjectURL(JavaScriptObject object);

    public abstract String revokeObjectURL(String objectURL);
}
