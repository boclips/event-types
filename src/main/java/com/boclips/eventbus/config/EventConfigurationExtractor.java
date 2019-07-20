package com.boclips.eventbus.config;

import com.boclips.eventbus.BoclipsEventListener;
import com.boclips.eventbus.BoclipsEvent;
import lombok.Builder;
import lombok.Data;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventConfigurationExtractor {
    public String getEventName(Class<?> eventType) {
        BoclipsEvent boclipsEvent = AnnotationUtils.findAnnotation(eventType, BoclipsEvent.class);

        if (boclipsEvent == null || boclipsEvent.value().isEmpty()) {
            throw new InvalidMessagingConfiguration(eventType.getName() + " not annotated with " + BoclipsEvent.class.getName());
        }

        return boclipsEvent.value();
    }

    public List<ListenerMethodInfo> getListenerMethods(Object object) {
        List<ListenerMethodInfo> methods = new ArrayList<>();
        Class<?> targetClass = AopUtils.isAopProxy(object) ? AopUtils.getTargetClass(object) : object.getClass();
        Method[] uniqueDeclaredMethods = ReflectionUtils.getUniqueDeclaredMethods(targetClass);
        for (Method method : uniqueDeclaredMethods) {
            BoclipsEventListener boclipsEventListener = AnnotatedElementUtils.findMergedAnnotation(method, BoclipsEventListener.class);
            if (boclipsEventListener != null && !method.isBridge()) {
                Class<?> eventType = method.getParameterTypes()[0];

                methods.add(ListenerMethodInfo.builder()
                        .method(method)
                        .eventType(eventType)
                        .eventName(getEventName(eventType))
                        .build());
            }
        }
        return methods;
    }

    @Data
    @Builder
    public static class ListenerMethodInfo {
        private final String eventName;
        private final Method method;
        private final Class<?> eventType;
    }
}
