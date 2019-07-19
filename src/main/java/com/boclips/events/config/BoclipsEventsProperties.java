package com.boclips.events.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pubsub")
@Data
public class BoclipsEventsProperties {
    private String project;
    private String consumerGroup;
    private String secret;
}
