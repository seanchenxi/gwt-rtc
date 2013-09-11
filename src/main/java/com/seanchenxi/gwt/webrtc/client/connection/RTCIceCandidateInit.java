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

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#rtcicecandidate-type
 */
public class RTCIceCandidateInit extends JavaScriptObject {

    protected RTCIceCandidateInit(){}

    public final native String getCandidate() /*-{
        return this.candidate;
    }-*/;

    public final native void setCandidate(String candidate) /*-{
        this.candidate = candidate;
    }-*/;

    public final native String getSdpMid() /*-{
        return this.sdpMid;
    }-*/;

    public final native void setSdpMid(String sdpMid) /*-{
        this.sdpMid = sdpMid;
    }-*/;

    public final native int getSdpMLineIndex() /*-{
        return this.sdpMLineIndex;
    }-*/;

    public final native void setSdpMLineIndex(int sdpMLineIndex) /*-{
        this.sdpMLineIndex = sdpMLineIndex;
    }-*/;

}
