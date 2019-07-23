package com.boclips.eventbus;

public enum ExceptionHandlingPolicy {
    /**
     * When an exception is raised from the event handler,
     * the underlying message is NOT acknowledged and therefore
     * will be re-delivered again.
     */
    RETRY,
    /**
     * The underlying message will be acknowledged despite
     * an exception having been raised from the event handler.
     */
    NO_RETRY
}
