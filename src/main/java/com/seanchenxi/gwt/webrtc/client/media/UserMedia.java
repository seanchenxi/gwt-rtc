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

import java.util.logging.Level;

import com.google.gwt.dom.client.Style;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.seanchenxi.gwt.webrtc.client.WebRTC;

/**
 * User: Xi
 */
public class UserMedia implements IsWidget {

    public interface Handler {
        void onSuccess(UserMedia media);
        void onError();
    }

    private final static String MAX_WIDTH = "100%";
    private final static String MIN_WIDTH = "auto";
    private final static String MAX_HEIGHT = "100%";
    private final static String MIN_HEIGHT = "112px";

    private static UserMedia localUserMedia;

    public static UserMedia getLocalUserMedia(boolean video, boolean audio, final Handler handler){
        if(localUserMedia == null){
            localUserMedia = new UserMedia();

            UserMediaConstraintsNative constraints = UserMediaConstraintsNative.create();
            WebRTC.getUserMedia(constraints, new UserMediaCallback() {
                @Override
                public void onSuccess(MediaStream stream) {
                    localUserMedia.useGrandSize();
                    localUserMedia.setMediaStream(stream);
                    if (handler != null) {
                        handler.onSuccess(localUserMedia);
                    }
                }

                @Override
                public void onError(String error) {
                    localUserMedia.setState(error);
                    if (handler != null) {
                        handler.onError();
                    }
                }
            });

        }
        return localUserMedia;
    }

    private SimplePanel player;
    private Video video;
    private HTML state;
    private MediaStream mediaStream;

    public UserMedia(){
        initView();
    }

    public void setState(String stateHTML){
        if(state == null) state = new HTML();
        if(!state.isAttached())
            player.setWidget(state);
        state.setHTML(stateHTML);
    }

    public void close(){
        video.pause();
        video = null;

        player.clear();
        player.removeFromParent();
        player = null;

        state = null;
        mediaStream = null;
    }

    public boolean isMediaStreamingOK(){
        MediaStreamTrackList videoTracks  = mediaStream == null ? null : mediaStream.getVideoTracks();
        return (videoTracks != null && videoTracks.getLength() == 0) || video.getCurrentTime() > 0;
    }

    public MediaStream getMediaStream() {
        return mediaStream;
    }

    public void setMediaStream(MediaStream stream){
        if((mediaStream = stream) != null){
            player.clear();
            player.setStyleName("UserMedia-Player");
            player.setWidget(video);
            video.setSrc(WebRTC.createObjectURL(mediaStream));
            video.play();
        }
    }

    public Video getVideo(){
        return video;
    }

    public UserMedia useGrandSize(){
        video.setWidth(MAX_WIDTH);
        video.setHeight(MAX_HEIGHT);
        player.getElement().getStyle().clearPaddingLeft();
        return this;
    }

    public UserMedia useNormalSize(){
        video.setWidth(MIN_WIDTH);
        video.setHeight(MIN_HEIGHT);
        player.getElement().getStyle().setMarginTop(4, Style.Unit.PX);
        player.getElement().getStyle().setMarginLeft(4, Style.Unit.PX);
        return this;
    }

    private void initView(){
        video = Video.createIfSupported();
        player = new SimplePanel();
        player.getElement().getStyle().setDisplay(Style.Display.INLINE_BLOCK);
        useNormalSize();
    }

    @Override
    public Widget asWidget() {
        return player;
    }
//
//    public void waitForRemoteVideo(final String target) {
//        log.log(Level.FINEST, "Waiting for " + target + "'s video stream ...");
//        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
//            @Override
//            public boolean execute() {
//                if (isMediaStreamingOK()) {
//                    log.log(Level.FINEST, target + "'s video stream arrived.");
//                    // here, means video streaming is received and playing
//                    // we can show hung up button or other things from here
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//        }, 100);
//    }
}
