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

package com.seanchenxi.gwt.html.client;

/**
 * Created by: Xi
 */
public enum EventType {
    
    CONNECTING("connecting"), 
    OPEN("open"),
    CLOSE("close"),
    ADD_STREAM("addstream"), 
    REMOVE_STREAM("removestream"),
    DATA_CHANNEL("datachannel"), 
    NEGOTIATION_NEEDED("negotiationneeded"),
    STATE_CHANGE("statechange"), 
    ICE_CHANGE("icechange"), 
    ICE_CANDIDATE("icecandidate"),
    ENDED("ended"),
    ADD_TRACK("addtrack"),
    REMOVE_TRACK("removetrack"),
    ERROR("error"),
    MESSAGE("message"),
    ABORT("abort"),
    LOAD("load"),
    LOAD_END("loadend"),
    LOAD_START("loadstart"),
    PROGRESS("progress");
    
    private final String value;
    private final String attribute;
    
    EventType(String value) {
        this(value, "on" + value);
    }
    
    EventType(String value, String attribute) {
        this.value = value;
        this.attribute = attribute;
    }

    public String getValue(){
        return this.value;
    }
    
    public String getAttribute(){
        return this.attribute;  
    }
    
    public static EventType parseValue(String value) {
        for (EventType event : values()) {
            if (event.value.equalsIgnoreCase(value)) {
                return event;
            }
        }
        return null;
    }
}
