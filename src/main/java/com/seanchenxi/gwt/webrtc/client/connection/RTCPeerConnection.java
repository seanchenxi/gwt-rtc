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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.shared.HandlerRegistration;
import com.seanchenxi.gwt.html.client.FNObject;
import com.seanchenxi.gwt.webrtc.client.Constraints;
import com.seanchenxi.gwt.webrtc.client.data.DataChannel;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelNative;
import com.seanchenxi.gwt.webrtc.client.data.DataChannelInit;
import com.seanchenxi.gwt.html.client.event.*;
import com.seanchenxi.gwt.webrtc.client.media.MediaStream;
import com.seanchenxi.gwt.webrtc.client.media.MediaStreamNative;

/**
 * User: Xi
 */
public class RTCPeerConnection extends FNObject {

    public final static String CONSTRAINT_MANDATORY_OFFERTORECEIVEAUDIO = "OfferToReceiveAudio";
    public final static String CONSTRAINT_MANDATORY_OFFERTORECEIVEVIDEO = "OfferToReceiveVideo";
    public final static String CONSTRAINT_OPTIONAL_RTPDATACHANNELS = "RtpDataChannels";
    public final static String CONSTRAINT_OPTIONAL_DTLSSRTPKEYAGREEMENT = "DtlsSrtpKeyAgreement";

    private final RTCPeerConnectionNative impl;

    protected RTCPeerConnection(RTCPeerConnectionNative impl) {
        this.impl = impl;
    }

    public static RTCPeerConnection as(JavaScriptObject jso) {
        assert is(jso);
        return new RTCPeerConnection(jso.<RTCPeerConnectionNative>cast());
    }

    public static final boolean is(JavaScriptObject jso){
        return RTCPeerConnectionNative.is(jso);
    }

    public void createOffer(RTCSessionDescriptionCallback callback, Constraints constraints) {
        impl.createOffer(callback, constraints);
    }

    public void close() {
        impl.close();
    }

    public List<MediaStream> getLocalStreams() {
        List<MediaStream> list = new ArrayList<MediaStream>();
        JsArray<MediaStreamNative> localStreams = impl.getLocalStreams();
        if (localStreams != null) {
            for (int i = 0; i < localStreams.length(); i++) {
                list.add(MediaStream.as(localStreams.get(i)));
            }
        }
        return list;
    }

    public void createAnswer(RTCSessionDescriptionCallback callback, Constraints constraints) {
        impl.createAnswer(callback, constraints);
    }

    public List<MediaStream> getRemoteStreams() {
        List<MediaStream> list = new ArrayList<MediaStream>();
        JsArray<MediaStreamNative> localStreams = impl.getRemoteStreams();
        if (localStreams != null) {
            for (int i = 0; i < localStreams.length(); i++) {
                list.add(MediaStream.as(localStreams.get(i)));
            }
        }
        return list;
    }

    public void addStream(MediaStream stream, Constraints constraints) {
        impl.addStream(stream.asNative(), constraints);
    }

    public void addStream(MediaStream stream) {
        impl.addStream(stream.asNative());
    }

    public final RTCPeerState getReadyState() {
        return RTCPeerState.parseValue(impl.getReadyStateNative());
    }

    public RTCSessionDescription getRemoteDescription() {
        return impl.getRemoteDescription();
    }

    public void setRemoteDescription(RTCSessionDescription sessionDescription) {
        impl.setRemoteDescription(sessionDescription);
    }

    public DataChannelNative createDataChannel(String label) {
        return impl.createDataChannel(label);
    }

    public void removeStream(MediaStreamNative stream) {
        impl.removeStream(stream);
    }

    public void addIceCandidate(RTCIceCandidate iceCandidate) {
        impl.addIceCandidate(iceCandidate);
    }

    public RTCSessionDescription getLocalDescription() {
        return impl.getLocalDescription();
    }

    public void setLocalDescription(RTCSessionDescription sessionDescription) {
        impl.setLocalDescription(sessionDescription);
    }

    public String getIceStateNative() {
        return impl.getIceStateNative();
    }

    public void updateIce(RTCConfiguration configuration, Constraints constraints, boolean restart) {
        impl.updateIce(configuration, constraints, restart);
    }

    public RTCIceState getIceState() {
        return RTCIceState.parseValue(impl.getIceStateNative());
    }

    public DataChannel createDataChannel(String label, DataChannelInit dataChannelDict) {
        return DataChannel.as(impl.createDataChannel(label, dataChannelDict));
    }

    public HandlerRegistration addAddStreamHandler(AddStreamEvent.Handler handler) {
        return addFnEventHandler(AddStreamEvent.getType(), handler);
    }

    public HandlerRegistration addDataChannelHandler(DataChannelEvent.Handler handler) {
        return addFnEventHandler(DataChannelEvent.getType(), handler);
    }

    public HandlerRegistration addIceCandidateHandler(IceCandidateEvent.Handler handler) {
        return addFnEventHandler(IceCandidateEvent.getType(), handler);
    }

    public HandlerRegistration addIceChangeHandler(IceChangeEvent.Handler handler) {
        return addFnEventHandler(IceChangeEvent.getType(), handler);
    }

    public HandlerRegistration addNegotiationNeededHandler(NegotiationNeededEvent.Handler handler) {
        return addFnEventHandler(NegotiationNeededEvent.getType(), handler);
    }

    public HandlerRegistration addOpenHandler(OpenEvent.Handler handler) {
        return addFnEventHandler(OpenEvent.getType(), handler);
    }

    public HandlerRegistration addRemoveStreamHandler(RemoveStreamEvent.Handler handler) {
        return addFnEventHandler(RemoveStreamEvent.getType(), handler);
    }

    public HandlerRegistration addStateChangeHandler(StateChangeEvent.Handler handler) {
        return addFnEventHandler(StateChangeEvent.getType(), handler);
    }

    @Override
    public JavaScriptObject asNative() {
        return impl;
    }
}
