package com.boclips.eventbus;

import com.boclips.eventbus.config.BoclipsEventsProperties;
import com.boclips.eventbus.config.BoclipsSubscriptionRegistrationPostProcessor;
import com.boclips.eventbus.infrastructure.PubSubEventBus;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@Import({
        BoclipsSubscriptionRegistrationPostProcessor.class,
        BoclipsEventsProperties.class,
        PubSubEventBus.class
})
@ConditionalOnProperty(name = "eventbus.enabled", havingValue = "true", matchIfMissing = true)
public @interface EnableBoclipsEvents {
}
