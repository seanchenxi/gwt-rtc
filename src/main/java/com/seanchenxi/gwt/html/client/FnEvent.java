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

import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.HasNativeEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public abstract class FnEvent<E extends NativeEvent, H extends EventHandler> extends GwtEvent<H>
    implements HasNativeEvent {

  public static class Type<H extends EventHandler> extends GwtEvent.Type<H> {
    private FnEvent<? extends NativeEvent, H> flyweight;
    private EventType type;

    public Type(EventType eventType, FnEvent<? extends NativeEvent, H> flyweight) {
      this.flyweight = flyweight;

      // Until we have eager clinits implemented, we are manually initializing
      // FnEvent here.
      if (registered == null) {
        init();
      }
      registered.unsafePut(eventType.name(), this);
      type = eventType;
    }

    public EventType getEventType() {
      return type;
    }
  }

  private static PrivateMap<Type<?>> registered;

  public static void fireNativeEvent(EventType eventType, NativeEvent nativeEvent, FNObject relativeFnObject) {
    fireNativeEvent(eventType, nativeEvent, relativeFnObject, relativeFnObject);
  }

  public static void fireNativeEvent(EventType eventType, NativeEvent nativeEvent,
      HasHandlers handlerSource, FNObject relativeFnObject) {
    assert nativeEvent != null : "nativeEvent must not be null";

    if (registered != null) {
      final Type<?> typeKey = registered.unsafeGet(eventType.name());
      if (typeKey != null) {
        // Store and restore native event just in case we are in recursive
        // loop.
        NativeEvent currentNative = typeKey.flyweight.nativeEvent;
        FNObject currentRelativeElem = typeKey.flyweight.relativeFnObject;
        typeKey.flyweight.setNativeEvent(nativeEvent);
        typeKey.flyweight.setRelativeFnObject(relativeFnObject);

        handlerSource.fireEvent(typeKey.flyweight);

        typeKey.flyweight.setNativeEvent(currentNative);
        typeKey.flyweight.setRelativeFnObject(currentRelativeElem);
      }
    }
  }

  // This method can go away once we have eager clinits.
  static void init() {
    registered = new PrivateMap<Type<?>>();
  }

  private E nativeEvent;
  private FNObject relativeFnObject;

  @Override
  public abstract Type<H> getAssociatedType();

  public final E getNativeEvent() {
    assertLive();
    return nativeEvent;
  }

  /**
   * Gets the element relative to which event coordinates will be measured.
   * If this element is <code>null</code>, event coordinates will be measured
   * relative to the window's client area.
   * 
   * @return the event's relative element
   */
  public final FNObject getRelativeFnObject() {
    assertLive();
    return relativeFnObject;
  }

  /**
   * Prevents the wrapped native event's default action.
   */
  public void preventDefault() {
    assertLive();
    nativeEvent.preventDefault();
  }

  /**
   * Sets the native event associated with this dom event. In general, dom
   * events should be fired using the static firing methods.
   * 
   * @param nativeEvent the native event
   */
  public final void setNativeEvent(NativeEvent nativeEvent) {
    this.nativeEvent = nativeEvent != null ? nativeEvent.<E>cast() : null;
  }

  /**
   * Gets the element relative to which event coordinates will be measured.
   *
   * @param relativeFnObject the event's relative FNObject
   */
  public void setRelativeFnObject(FNObject relativeFnObject) {
    this.relativeFnObject = relativeFnObject;
  }

  /**
   * Stops the propagation of the underlying native event.
   */
  public void stopPropagation() {
    assertLive();
    nativeEvent.stopPropagation();
  }
}
