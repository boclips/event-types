package com.boclips.eventbus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TestEventHandler<T> implements EventHandler<T>, Iterable<T> {
    private final List<T> events = new ArrayList<>();

    @Override
    public void handle(T event) {
        events.add(event);
    }

    public List<T> getEvents() {
        return events;
    }

    public T getEvent() {
        switch(events.size()) {
            case 0:
                throw new IllegalStateException("No events received");
            case 1:
                return events.get(0);
            default:
                throw new IllegalStateException(String.format("%d messages received", events.size()));
        }
    }

    @Override
    public Iterator<T> iterator() {
        return events.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        events.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return events.spliterator();
    }
}
