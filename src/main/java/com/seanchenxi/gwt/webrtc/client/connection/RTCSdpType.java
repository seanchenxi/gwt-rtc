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

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#idl-def-RTCSdpType
 */
public enum RTCSdpType {

    OFFER("offer"), PR_ANSWER("pranwser"), ANSWER("answer");

    private final String value;

    private RTCSdpType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    public static RTCSdpType parseValue(String value){
        for(RTCSdpType type : values()){
            if(type.value.equalsIgnoreCase(value)){
                return type;
            }
        }
        return null;
    }
}
