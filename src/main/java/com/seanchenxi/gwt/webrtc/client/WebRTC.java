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

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.webrtc.client.connection.*;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelInit;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaCallback;
import com.seanchenxi.gwt.webrtc.client.media.UserMediaConstraints;

public class WebRTC {

    private final static WebRTCImpl IMPL;

    static {
        IMPL = GWT.create(WebRTCImpl.class);
    }

    public static boolean isWebkit() {
        return IMPL.isWebkit();
    }

    public static boolean isGecko() {
        return IMPL.isGecko();
    }

    public static void getUserMedia(UserMediaConstraints constraints, UserMediaCallback callback) {
        IMPL.getUserMedia(constraints, callback);
    }

    public static RTCPeerConnection createRTCPeerConnection(RTCConfiguration configuration) {
        return RTCPeerConnection.as(IMPL.createRTCPeerConnectionNative(configuration));
    }

    public static RTCPeerConnection createRTCPeerConnection(RTCConfiguration configuration, Constraints constraints) {
        return RTCPeerConnection.as(IMPL.createRTCPeerConnectionNative(configuration, constraints));
    }

    public static RTCSessionDescription createRTCSessionDescription(RTCSessionDescriptionInit init) {
        return IMPL.createRTCSessionDescription(init);
    }

    public static RTCIceCandidate createRTCIceCandidate(RTCIceCandidateInit candidateInitDict) {
        return IMPL.createRTCIceCandidate(candidateInitDict);
    }

    public static RTCSessionDescriptionInit createRTCSessionDescriptionInit(RTCSdpType type, String sdp) {
        return IMPL.createRTCSessionDescriptionInit(type, sdp);
    }

    public static RTCIceCandidateInit createRTCIceCandidateInit(String candidate, String sdpMid, int sdpMLineIndex) {
        return IMPL.createRTCIceCandidateInit(candidate, sdpMid, sdpMLineIndex);
    }
    
    public static RTCIceServer createRTCIceServer(String url, String credential){
        return IMPL.createRTCIceServer(url, credential);    
    }

    public static RTCIceServer createRTCIceServer(String url){
        return IMPL.createRTCIceServer(url, null);
    }
    
    public static RTCConfiguration createRTCConfiguration(JsArray<RTCIceServer> iceServers){
        return IMPL.createRTCConfiguration(iceServers);
    }
    
    public static DataChannelInit createDataChannelInit(boolean reliable) {
        return IMPL.createDataChannelInit(reliable);
    }

    public static Constraints createConstraints() {
        return IMPL.createConstraints();
    }

    public static String createObjectURL(FNObject object) {
        return createObjectURL(object.asNative());
    }

    public static String createObjectURL(JavaScriptObject object) {
        return IMPL.createObjectURL(object);
    }
}
