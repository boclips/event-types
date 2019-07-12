package com.boclips.events.spring;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binding.BindingBeanDefinitionRegistryUtils;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Subscription channels configuration.
 * <p>
 * This class scans application beans looking for {@link StreamListener}
 * methods and registers Cloud Stream binding targets for them.
 * <p>
 * In PubSub, this results in creation of subscriptions corresponding to
 * the annotated methods. Therefore, subscriptions will not be created
 * for topics which do not have a corresponding {@link StreamListener}.
 */
public class BoclipsSubscriptionRegistrationPostProcessor implements BeanPostProcessor {

    private final BeanDefinitionRegistry registry;

    private final Map<String, Class<?>> subscriptionInterfaceByChannelName;

    public BoclipsSubscriptionRegistrationPostProcessor(ConfigurableBeanFactory configurableBeanFactory) {
        this.registry = (BeanDefinitionRegistry) configurableBeanFactory;
        this.subscriptionInterfaceByChannelName = new HashMap<>();

        for (Class<?> subscriptionInterface : subscriptionInterfaceclasses()) {
            for (Method method : subscriptionInterface.getDeclaredMethods()) {
                Input input = AnnotationUtils.findAnnotation(method, Input.class);
                if (input == null) {
                    continue;
                }
                subscriptionInterfaceByChannelName.put(input.value(), subscriptionInterface);
            }
        }
    }

    private Iterable<Class<?>> subscriptionInterfaceclasses() {
        Set<BeanDefinition> definitions = new PackageScanner().findCandidateComponents("com/boclips/events/config/subscriptions");
        return definitions
                .stream()
                .map(this::classFrom)
                .collect(Collectors.toList());
    }

    private Class<?> classFrom(BeanDefinition beanDefinition) {
        String beanClassName = beanDefinition.getBeanClassName();
        try {
            return Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            throw new UnsupportedOperationException("Could not load subscription interface candidate: " + beanClassName, e);
        }
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        for (StreamListener streamListener : getStreamListenerAnnotationFomMethodsOf(bean)) {
            String channelName = streamListener.target();
            Class<?> subscriptionInterface = subscriptionInterfaceByChannelName.get(channelName);
            if (subscriptionInterface == null) {
                throw new IllegalStateException("No subscription interface for class" + channelName);
            }
            registerBindingTargetBeanDefinitions(subscriptionInterface, registry);
        }

        return bean;
    }

    private Iterable<StreamListener> getStreamListenerAnnotationFomMethodsOf(Object bean) {
        List<StreamListener> listeners = new ArrayList<>();
        Class<?> targetClass = AopUtils.isAopProxy(bean) ? AopUtils.getTargetClass(bean) : bean.getClass();
        Method[] uniqueDeclaredMethods = ReflectionUtils.getUniqueDeclaredMethods(targetClass);
        for (Method method : uniqueDeclaredMethods) {
            StreamListener streamListener = AnnotatedElementUtils.findMergedAnnotation(method, StreamListener.class);
            if (streamListener != null && !method.isBridge()) {
                listeners.add(streamListener);
            }
        }
        return listeners;
    }

    private void registerBindingTargetBeanDefinitions(Class<?> type, BeanDefinitionRegistry registry) {
        AnnotationMetadata metadata = new StandardAnnotationMetadata(BoclipsEventsConfiguration.class);
        BindingBeanDefinitionRegistryUtils
                .registerBindingTargetBeanDefinitions(type, type.getName(), registry);
        BindingBeanDefinitionRegistryUtils
                .registerBindingTargetsQualifiedBeanDefinitions(ClassUtils
                                .resolveClassName(metadata.getClassName(), null), type,
                        registry);
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
