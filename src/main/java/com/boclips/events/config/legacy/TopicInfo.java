package com.boclips.events.config.legacy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TopicInfo {

    private final String topicName;
    private final String channelName;

    public static TopicInfo fromChannelName(String channelName, String channelSuffix) {
        if (!channelName.endsWith(channelSuffix)) {
            throw new RuntimeException(String.format("Expected suffix %s for channel %s", channelSuffix, channelName));
        }

        String topicName = channelName.replaceFirst(channelSuffix + "$", "");

        return TopicInfo.builder()
                .topicName(topicName)
                .channelName(channelName)
                .build();
    }
}
