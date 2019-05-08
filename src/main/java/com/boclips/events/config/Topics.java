package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Topics {
    String SUFFIX = "-topic";
    String VIDEO_ANALYSIS_REQUESTED = TopicNames.VIDEO_ANALYSIS_REQUESTED + SUFFIX;
    String VIDEO_INDEXED = TopicNames.VIDEO_INDEXED + SUFFIX;
    String VIDEO_ANALYSED = TopicNames.VIDEO_ANALYSED + SUFFIX;

    @Output(VIDEO_ANALYSIS_REQUESTED)
    MessageChannel videoAnalysisRequested();

    @Output(VIDEO_INDEXED)
    MessageChannel videoIndexed();

    @Output(VIDEO_ANALYSED)
    MessageChannel videoAnalysed();
}
