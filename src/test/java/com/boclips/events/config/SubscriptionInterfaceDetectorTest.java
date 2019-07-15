package com.boclips.events.config;

import com.boclips.events.config.subscriptions.VideoUpdatedSubscription;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscriptionInterfaceDetectorTest {

    @Test
    public void detectsSubscriptionInterfaces() {
        Iterable<Class<?>> interfaces = SubscriptionInterfaceDetector.subscriptionInterfaceClasses();

        assertThat(interfaces).contains(VideoUpdatedSubscription.class);
    }
}
