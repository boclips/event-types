package com.boclips.events.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Topics {
    String SUFFIX = "-topic";
    String VIDEOS_TO_ANALYSE = TopicNames.VIDEOS_TO_ANALYSE + SUFFIX;
    String ANALYSED_VIDEO_IDS = TopicNames.ANALYSED_VIDEO_IDS + SUFFIX;
    String ANALYSED_VIDEOS = TopicNames.ANALYSED_VIDEOS + SUFFIX;

    @Output(VIDEOS_TO_ANALYSE)
    MessageChannel videosToAnalyse();

    @Output(ANALYSED_VIDEO_IDS)
    MessageChannel analysedVideoIds();

    @Output(ANALYSED_VIDEOS)
    MessageChannel analysedVideos();
}
