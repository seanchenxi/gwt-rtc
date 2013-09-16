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
import com.seanchenxi.gwt.webrtc.client.connection.*;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaCallback;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaConstraints;

/**
 * User: Xi
 */
public class WebRTCImplWebkit extends WebRTCImpl {

    @Override
    public final boolean isGecko() {
        return false;
    }

    @Override
    public final boolean isWebkit() {
        return true;
    }

    @Override
    public final native void getUserMedia(UserMediaConstraints constraints, UserMediaCallback callback) /*-{
        var successCallback = $entry(function (localMediaStream) {
            @com.seanchenxi.gwt.webrtc.client.WebRTCImpl::handleUserMediaCallback(Lcom/seanchenxi/gwt/webrtc/client/media/UserMediaCallback;Lcom/seanchenxi/gwt/webrtc/client/media/MediaStreamNative;Ljava/lang/String;)(callback, localMediaStream, undefined);
        });
        var errorCallback = $entry(function (err) {
            @com.seanchenxi.gwt.webrtc.client.WebRTCImpl::handleUserMediaCallback(Lcom/seanchenxi/gwt/webrtc/client/media/UserMediaCallback;Lcom/seanchenxi/gwt/webrtc/client/media/MediaStreamNative;Ljava/lang/String;)(callback, undefined, JSON.stringify(err));
        });
        $wnd.navigator.webkitGetUserMedia(constraints, successCallback, errorCallback);
    }-*/;

    @Override
    public final native RTCPeerConnectionNative createRTCPeerConnectionNative(RTCConfiguration configuration, Constraints constraints) /*-{
        return new webkitRTCPeerConnection(configuration, constraints);
    }-*/;

    @Override
    public final native RTCSessionDescription createRTCSessionDescription(RTCSessionDescriptionInit init) /*-{
        return new RTCSessionDescription(init);
    }-*/;

    @Override
    public final native RTCIceCandidate createRTCIceCandidate(RTCIceCandidateInit candidateInitDict) /*-{
        return new RTCIceCandidate(candidateInitDict);
    }-*/;

    @Override
    public final native String createObjectURL(JavaScriptObject object) /*-{
        return $wnd.webkitURL.createObjectURL(object);
    }-*/;

    @Override
    public final native String revokeObjectURL(String objectURL) /*-{
        return $wnd.webkitURL.revokeObjectURL(objectURL);
    }-*/;
}
