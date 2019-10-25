package com.boclips.eventbus.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class EventSerializer {

    private final ObjectMapper objectMapper;

    public EventSerializer() {
        this(ObjectMapperProvider.get());
    }

    public EventSerializer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public byte[] serialise(Object event) {
        try {
            return objectMapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed serialising event: " + event);
        }
    }

    public Object deserialise(Object event, byte[] eventBytes) {
        try {
            return objectMapper.readValue(eventBytes, event.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Failed de-serialising event: " + event, e);
        }
    }
}
