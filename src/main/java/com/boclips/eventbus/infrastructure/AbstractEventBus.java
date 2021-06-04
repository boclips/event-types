package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.EventBus;
import com.boclips.eventbus.EventHandler;
import com.boclips.eventbus.config.EventConfigurationExtractor;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.singletonList;

public abstract class AbstractEventBus implements EventBus {

    private final EventConfigurationExtractor eventConfigurationExtractor = new EventConfigurationExtractor();

    protected abstract <T> void doSubscribe(String topicName, String methodName, Class<T> eventType, EventHandler<? super T> eventHandler);
    protected abstract void doUnsubscribe(String topicName);
    protected abstract void doPublish(Iterable<?> events, String topicName);

    @Override
    public final <T> void subscribe(Class<T> eventType, EventHandler<? super T> eventHandler, String methodName) {
        doSubscribe(topicName(eventType), methodName, eventType, eventHandler);
    }

    @Override
    public final void unsubscribe(Class<?> eventType) {
        doUnsubscribe(topicName(eventType));
    }

    @Override
    public final <T> void publish(Iterable<T> events) {
        doPublish(events, topicName(singleClass(events)));
    }

    @Override
    public final <T> void publish(T event) {
        doPublish(singletonList(event), topicName(event.getClass()));
    }

    private Class<?> singleClass(Iterable<?> events) {
        Set<Class<?>> classes = new HashSet<>();
        for (Object event : events) {
            classes.add(event.getClass());
        }
        switch (classes.size()) {
            case 0:
                throw new IllegalArgumentException("No events to publish");
            case 1:
                return classes.iterator().next();
            default:
                throw new IllegalArgumentException("All events published in bulk mode must have the same class");
        }
    }

    private String topicName(Class<?> cls) {
        return eventConfigurationExtractor.getEventName(cls);
    }
}
