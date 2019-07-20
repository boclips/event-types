package com.boclips.eventbus.config;

public class InvalidMessagingConfiguration extends RuntimeException {
    public InvalidMessagingConfiguration(String message) {
        super(message);
    }
}
