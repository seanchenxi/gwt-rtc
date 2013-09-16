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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.*;
import com.seanchenxi.gwt.html.client.event.FnEvent;

/**
 * User: Xi
 */
public abstract class FNObject implements HasHandlers {

    private HandlerManager handlerManager;

    protected FNObject(){}

    public abstract JavaScriptObject asNative();

    public <H extends EventHandler> HandlerRegistration addFnEventHandler(final FnEvent.Type<H> type, H handler) {
        final HandlerRegistration handlerRegistration = ensureHandlers().addHandler(type, handler);
        if (getHandlerCount(type) == 1) {
            EventDispatcher.sinkEvent(asNative(), type.getEventType(), FNObject.this);
        }
        return new HandlerRegistration() {
            @Override
            public void removeHandler() {
                handlerRegistration.removeHandler();
                if (getHandlerCount(type) < 1) {
                    EventDispatcher.unsinkEvent(asNative(), type.getEventType());
                }
            }
        };
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        ensureHandlers().fireEvent(event);
    }

    protected final int getHandlerCount(GwtEvent.Type<?> type){
        return handlerManager == null ? 0 : handlerManager.getHandlerCount(type);
    }

    private HandlerManager ensureHandlers() {
        return handlerManager == null ? handlerManager = new HandlerManager(this) : handlerManager;
    }
}
