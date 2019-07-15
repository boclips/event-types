package com.boclips.events.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubscriptionInterfaceDetector {

    public static List<Class<?>> subscriptionInterfaceClasses() {
        Set<BeanDefinition> definitions = new PackageScanner().findCandidateComponents("com/boclips/events/config/subscriptions");
        return definitions
                .stream()
                .map(SubscriptionInterfaceDetector::classFrom)
                .collect(Collectors.toList());
    }

    private static Class<?> classFrom(BeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            return Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Could not load subscription interface candidate: " + beanClassName, e);
        }
    }

    static class PackageScanner extends ClassPathScanningCandidateComponentProvider {

        PackageScanner() {
            super(false);
            addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            return true;
        }
    }
}
