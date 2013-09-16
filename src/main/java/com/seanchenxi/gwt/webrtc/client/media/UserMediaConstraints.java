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

package com.seanchenxi.gwt.webrtc.client.media;

import com.google.gwt.core.client.JavaScriptObject;
import com.seanchenxi.gwt.webrtc.client.Constraints;

/**
 * User: Xi
 */
public class UserMediaConstraints extends Constraints {

    public static UserMediaConstraints create(){
        return JavaScriptObject.createObject().cast();
    }

    protected UserMediaConstraints() {
    }

    public final void setVideo(boolean video){
        set("video", video);
    }

    public final void setVideo(Constraints constraints){
        set("video", constraints);
    }

    public final void setAudio(boolean audio){
        set("audio", audio);
    }

}
