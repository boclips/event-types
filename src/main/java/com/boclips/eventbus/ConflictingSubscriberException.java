package com.boclips.eventbus;

public class ConflictingSubscriberException extends RuntimeException {

    public ConflictingSubscriberException(String message) {
        super(message);
    }
}
