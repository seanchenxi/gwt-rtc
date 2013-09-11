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

package com.seanchenxi.gwt.webrtc.client.data;

/**
 * User: Xi
 * @see: http://www.w3.org/TR/webrtc/#idl-def-DataChannelState
 */
public enum DataChannelState {
  CONNECTING("connecting"),
  OPEN("open"),
  CLOSING("closing"),
  CLOSED("closed");

  private final String value;

  private DataChannelState(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static DataChannelState parseValue(String value) {
    for (DataChannelState state : values()) {
      if (state.value.equalsIgnoreCase(value)) {
        return state;
      }
    }
    return null;
  }
}