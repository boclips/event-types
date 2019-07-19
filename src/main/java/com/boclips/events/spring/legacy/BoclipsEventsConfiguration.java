package com.boclips.events.spring.legacy;

import com.boclips.events.config.legacy.BoclipsMessagingConfiguration;
import com.boclips.events.config.legacy.Topics;
import lombok.NonNull;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableBinding({Topics.class})
public class BoclipsEventsConfiguration {

    @Primary
    @Bean
    public @NonNull BindingServiceProperties bindingServiceProperties() {
        return new BoclipsMessagingConfiguration()
                .forContext(BoclipsEventsConfiguration.class);
    }

}
