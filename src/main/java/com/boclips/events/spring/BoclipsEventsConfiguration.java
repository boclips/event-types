package com.boclips.events.spring;

import com.boclips.events.config.BoclipsMessagingConfiguration;
import com.boclips.events.config.Subscriptions;
import com.boclips.events.config.Topics;
import lombok.NonNull;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.BindingServiceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableBinding(value = {Topics.class, Subscriptions.class})
class BoclipsEventsConfiguration {

    private final ApplicationContext applicationContext;

    BoclipsEventsConfiguration(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Primary
    @Bean
    public @NonNull BindingServiceProperties bindingServiceProperties() {
        Map<String, Object> annotatedBeans = applicationContext.getBeansWithAnnotation(EnableBoclipsEvents.class);

        if (annotatedBeans.isEmpty()) {
            throw new IllegalStateException("Found no beans annotated with " + EnableBoclipsEvents.class.getName());
        }

        if (annotatedBeans.size() > 1) {
            throw new IllegalStateException("Found multiple beans annotated with " + EnableBoclipsEvents.class.getName());
        }

        Object bean = annotatedBeans.values().iterator().next();

        EnableBoclipsEvents annotation = AnnotationUtils.findAnnotation(bean.getClass(), EnableBoclipsEvents.class);

        return new BoclipsMessagingConfiguration(annotation.appName())
                .forContext(BoclipsEventsConfiguration.class);
    }
}
