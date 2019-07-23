package com.boclips.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BoclipsEventListener {

    ExceptionHandlingPolicy onException() default ExceptionHandlingPolicy.NO_RETRY;
}
