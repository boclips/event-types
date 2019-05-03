package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Subscriptions {

    String SUFFIX = "-subscription";

    String VIDEOS_TO_ANALYSE = TopicNames.VIDEOS_TO_ANALYSE + SUFFIX;
    String ANALYSED_VIDEO_IDS = TopicNames.ANALYSED_VIDEO_IDS + SUFFIX;
    String ANALYSED_VIDEOS = TopicNames.ANALYSED_VIDEOS + SUFFIX;

    @Input(VIDEOS_TO_ANALYSE)
    SubscribableChannel videosToAnalyse();

    @Input(ANALYSED_VIDEO_IDS)
    SubscribableChannel analysedVideoIds();

    @Input(ANALYSED_VIDEOS)
    SubscribableChannel analysedVideos();

}
