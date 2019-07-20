package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.events.video.VideoUpdated;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynchronousEventBusTest {

    @Test
    void publish_whenNoSubscriber_shouldNotThrow() {
        assertDoesNotThrow(() -> {
            new SynchronousEventBus().publish(VideoUpdated.builder().videoId("").contentPartnerName("").title("").build());
        });
    }
}
