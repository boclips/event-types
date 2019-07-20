package com.boclips.eventbus.config;

import com.boclips.eventbus.EventBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BoclipsSubscriptionRegistrationPostProcessor implements BeanPostProcessor {
    private EventConfigurationExtractor eventConfigurationExtractor;
    private EventBus eventBus;

    public BoclipsSubscriptionRegistrationPostProcessor(EventBus eventBus) {
        this.eventConfigurationExtractor = new EventConfigurationExtractor();
        this.eventBus = eventBus;
    }

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) throws BeansException {
        for (EventConfigurationExtractor.ListenerMethodInfo listenerMethod : eventConfigurationExtractor.getListenerMethods(object)) {
            EventListener listener = new EventListener(object, listenerMethod);
            eventBus.subscribe(listener.getEventType(), event -> listener.receive(event));
        }
        return object;
    }
}
