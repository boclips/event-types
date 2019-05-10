package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


public interface Subscriptions {

    String SUFFIX = "-subscription";

    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String LEGACY_ORDER_SUBMITTED = TopicNames.LEGACY_ORDER_SUBMITTED + SUFFIX;
    String USER_ACTIVATED = TopicNames.USER_ACTIVATED + SUFFIX;

    @Input(VIDEO_PLAYBACK_SYNC_REQUESTED)
    SubscribableChannel videoPlaybackSyncRequested();

    @Input(VIDEO_ANALYSIS_REQUESTED)
    SubscribableChannel videoAnalysisRequested();

    @Input(VIDEO_INDEXED)
    SubscribableChannel videoIndexed();

    @Input(VIDEO_ANALYSED)
    SubscribableChannel videoAnalysed();

    @Input(LEGACY_ORDER_SUBMITTED)
    SubscribableChannel legacyOrderSubmissions();

    @Input(USER_ACTIVATED)
    SubscribableChannel userActivated();

}
