package com.boclips.eventbus.config;

import java.lang.reflect.InvocationTargetException;

public class EventListener {

    private final Object object;
    private final EventConfigurationExtractor.ListenerMethodInfo method;

    public EventListener(Object object, EventConfigurationExtractor.ListenerMethodInfo method) {
        this.object = object;
        this.method = method;
    }

    public void receive(Object message) {
        try {
            method.getMethod().invoke(object, message);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public Class<?> getEventType() {
        return method.getEventType();
    }

}
