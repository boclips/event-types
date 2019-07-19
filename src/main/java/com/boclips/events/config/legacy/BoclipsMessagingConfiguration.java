package com.boclips.events.config.legacy;

import lombok.NonNull;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.cloud.stream.config.BindingServiceProperties;

import java.util.*;

public class BoclipsMessagingConfiguration {

    @NonNull
    public <T> BindingServiceProperties forContext(Class<T> contextClass) {

        EnableBinding enableBindingAnnotation = contextClass.getAnnotation(EnableBinding.class);

        if (enableBindingAnnotation == null) {
            throw new IllegalArgumentException("Class " + contextClass.getName() + " must be annotated with " + EnableBinding.class.getName());
        }

        List<Class<?>> channelInterfaces = new ArrayList<>();
        channelInterfaces.addAll(Arrays.asList(enableBindingAnnotation.value()));
        channelInterfaces.addAll(SubscriptionInterfaceDetector.subscriptionInterfaceClasses());

        Map<String, BindingProperties> bindings = new HashMap<>();

        channelInterfaces.forEach(channelInterface -> {
            TopicDetector.scanTopicChannels(channelInterface).forEach(topic ->
                    bindings.put(topic.getChannelName(), topicBindingProperties(topic.getTopicName()))
            );

            TopicDetector.scanSubscriptionChannels(channelInterface).forEach(topic ->
                    bindings.put(topic.getChannelName(), subscriptionBindingProperties(topic.getTopicName()))
            );
        });

        BindingServiceProperties bindingServiceProperties = new BindingServiceProperties();
        bindingServiceProperties.setBindings(bindings);
        return bindingServiceProperties;
    }

    private BindingProperties bindingProperties(String topicName) {
        BindingProperties properties = new BindingProperties();
        properties.setDestination(topicName);
        return properties;
    }

    private BindingProperties topicBindingProperties(String topicName) {
        return bindingProperties(topicName);
    }

    private BindingProperties subscriptionBindingProperties(String topicName) {
        BindingProperties properties = bindingProperties(topicName);
        properties.setGroup("aint matter");
        return properties;
    }
}
