package com.boclips.eventbus.test;

import com.boclips.eventbus.infrastructure.SynchronousFakeEventBus;
import org.assertj.core.api.AbstractAssert;

import java.util.List;
import java.util.stream.Collectors;

public class EventBusAssert extends AbstractAssert<EventBusAssert, SynchronousFakeEventBus> {

    public EventBusAssert(SynchronousFakeEventBus actual) {
        super(actual, EventBusAssert.class);
    }

    public static EventBusAssert assertThat(SynchronousFakeEventBus eventBus) {
        return new EventBusAssert(eventBus);
    }

    public <TEvent> EventBusAssert hasReceived(TEvent event) {
        List<TEvent> receivedEvents = actual.getEventsOfType(event.getClass());
        if(!receivedEvents.contains(event)) {
            String receivedEventsStr = receivedEvents.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
            failWithMessage("Expected received events %s to contain %s", receivedEventsStr, event);
        }
        return this;
    }
}
