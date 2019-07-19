package com.boclips.events.config.legacy;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopicDetector {

    public static <T> Set<TopicInfo> scanTopicChannels(Class<T> cls) {
        return getAnnotations(cls, Output.class)
                .map(Output::value)
                .map(channelName -> TopicInfo.fromChannelName(channelName, "-topic"))
                .collect(Collectors.toSet());
    }

    public static <T> Set<TopicInfo> scanSubscriptionChannels(Class<T> cls) {
        return getAnnotations(cls, Input.class)
                .map(Input::value)
                .map(channelName -> TopicInfo.fromChannelName(channelName, "-subscription"))
                .collect(Collectors.toSet());
    }

    private static <TClass, TAnnotation extends Annotation> Stream<TAnnotation> getAnnotations(Class<TClass> cls, Class<TAnnotation> annotationClass) {
        return Arrays.stream(cls.getMethods())
                .map(method -> method.getAnnotation(annotationClass))
                .filter(Objects::nonNull);
    }
}
