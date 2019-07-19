package com.boclips.events;

import com.boclips.events.config.BoclipsEventsProperties;
import com.boclips.events.spring.legacy.BoclipsEventsConfiguration;
import com.boclips.events.config.BoclipsSubscriptionRegistrationPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Configuration
@Import({BoclipsEventsConfiguration.class, BoclipsSubscriptionRegistrationPostProcessor.class, BoclipsEventsProperties.class})
public @interface EnableBoclipsEvents {
}
