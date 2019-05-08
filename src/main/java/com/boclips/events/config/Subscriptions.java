package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Subscriptions {

    String SUFFIX = "-subscription";

    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String LEGACY_ORDER_SUBMITTED = TopicNames.LEGACY_ORDER_SUBMITTED + SUFFIX;

    @Input(VIDEO_ANALYSIS_REQUESTED)
    SubscribableChannel videosToAnalyse();

    @Input(VIDEO_INDEXED)
    SubscribableChannel analysedVideoIds();

    @Input(VIDEO_ANALYSED)
    SubscribableChannel analysedVideos();

    @Input(LEGACY_ORDER_SUBMITTED)
    SubscribableChannel legacyOrderSubmissions();

}
