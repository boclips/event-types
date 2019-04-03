package com.boclips.events.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicInfo {

    private final String topicName;

    private final String channelName;

    static TopicInfo fromChannelName(String channelName, String channelSuffix) {
        if (!channelName.endsWith(channelSuffix)) {
            throw new RuntimeException("Expected suffix $channelSuffix for channel $channelName");
        }

        String topicName = channelName.replaceFirst(channelSuffix + "$", "");

        return TopicInfo.builder()
                .topicName(topicName)
                .channelName(channelName)
                .build();
    }
}
