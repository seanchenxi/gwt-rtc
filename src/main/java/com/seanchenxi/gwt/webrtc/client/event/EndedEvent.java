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

package com.seanchenxi.gwt.webrtc.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.seanchenxi.gwt.html.client.EventType;

/**
 * User: Xi
 */
public class EndedEvent extends BaseFnEvent<EndedEvent.Handler> {

    public interface Handler extends EventHandler {
        void onEnded(EndedEvent event);
    }

    static Type<Handler> TYPE;

    private EndedEvent() {
        super();
    }

    public static Type<Handler> getType() {
        if (TYPE == null) {
            TYPE = new Type<Handler>(EventType.ENDED, new EndedEvent());
        }
        return TYPE;
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onEnded(this);
    }
}