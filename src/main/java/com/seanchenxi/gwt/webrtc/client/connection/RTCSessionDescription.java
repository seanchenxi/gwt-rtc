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
 * @see: http://www.w3.org/TR/webrtc/#rtcsessiondescription-class
 */
public final class RTCSessionDescription extends JavaScriptObject {

    protected RTCSessionDescription() {
    }

    public final RTCSdpType getType() {
        return RTCSdpType.parseValue(getTypeNative());
    }

    public final void setType(RTCSdpType type) {
        setTypeNative(type.getValue());
    }

    public native void setSdp(String sdp) /*-{
        this.sdp = sdp;
    }-*/;

    public native String getSdp() /*-{
        return this.sdp;
    }-*/;

    private native void setTypeNative(String type) /*-{
        this.type = type;
    }-*/;

    private native String getTypeNative() /*-{
        return this.type;
    }-*/;
}
