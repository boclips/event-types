package com.boclips.eventbus.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperProvider {

    public static ObjectMapper get() {
        return new ObjectMapper();
    }
}
