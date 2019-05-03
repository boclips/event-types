package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import static com.boclips.events.config.TopicNames.*;

public interface Topics {
    String SUFFIX = "-topic";

    @Output(VIDEOS_TO_ANALYSE + SUFFIX)
    MessageChannel videosToAnalyse();

    @Output(ANALYSED_VIDEO_IDS + SUFFIX)
    MessageChannel analysedVideoIds();

    @Output(ANALYSED_VIDEOS + SUFFIX)
    MessageChannel analysedVideos();
}
