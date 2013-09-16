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

/**
 * Created by: Xi
 */
public class EventDispatcher {

    public static native void sinkEvent(JavaScriptObject obj, EventType eventType, FNObject fnObject) /*-{
        var attr = eventType.@com.seanchenxi.gwt.html.client.EventType::getAttribute()();
        obj[attr] = (fnObject == null) ? undefined : @com.seanchenxi.gwt.html.client.EventDispatcher::dispatchEvent(Lcom/seanchenxi/gwt/html/client/EventType;Lcom/seanchenxi/gwt/html/client/FNObject;)(eventType, fnObject);
    }-*/;

    public static void unsinkEvent(JavaScriptObject obj, EventType eventType) {
        sinkEvent(obj, eventType, null);
    }

    private static native JavaScriptObject dispatchEvent(EventType eventType, FNObject fnObject) /*-{
        return $entry(function(evt) {
            //var exceptedType = eventType.@com.seanchenxi.gwt.html.client.EventType::getValue()();
            //if(console) console.log("\nEventDispatcher -> dispatchEvent " + evt + "(type="+evt.type+", exceptedType=" + exceptedType + ")\n");
            @com.seanchenxi.gwt.html.client.event.FnEvent::fireNativeEvent(Lcom/seanchenxi/gwt/html/client/EventType;Lcom/google/gwt/dom/client/NativeEvent;Lcom/seanchenxi/gwt/html/client/FNObject;)(eventType, evt, fnObject);
        });
    }-*/;

    
}
