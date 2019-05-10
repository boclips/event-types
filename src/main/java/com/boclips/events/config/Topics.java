package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Topics {
    String SUFFIX = "-topic";
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_PLAYBACK_SYNC_REQUESTED = TopicNames.VIDEO_PLAYBACK_SYNC_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;
    String USER_ACTIVATED = TopicNames.USER_ACTIVATED + SUFFIX;

    @Output(VIDEO_PLAYBACK_SYNC_REQUESTED)
    MessageChannel videoPlaybackSyncRequested();

    @Output(VIDEO_ANALYSIS_REQUESTED)
    MessageChannel videoAnalysisRequested();

    @Output(VIDEO_INDEXED)
    MessageChannel videoIndexed();

    @Output(VIDEO_ANALYSED)
    MessageChannel videoAnalysed();

    @Output(USER_ACTIVATED)
    MessageChannel userActivated();
}
