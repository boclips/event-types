package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.events.video.VideoAnalysed;
import com.boclips.eventbus.events.video.VideoUpdated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SynchronousFakeEventBusTest {

    private SynchronousFakeEventBus synchronousFakeEventBus;

    @BeforeEach
    void setUp() {
        synchronousFakeEventBus = new SynchronousFakeEventBus();

        synchronousFakeEventBus.publish(anEvent());
    }

    @Test
    void publish_whenNoSubscriber_shouldNotThrow() {
        assertDoesNotThrow(() -> new SynchronousFakeEventBus().publish(anEvent()));
    }

    @Test
    void publish_canProbeForReceivedEventType() {
        assertThat(synchronousFakeEventBus.hasReceivedEventOfType(VideoUpdated.class)).isTrue();
        assertThat(synchronousFakeEventBus.hasReceivedEventOfType(VideoAnalysed.class)).isFalse();
    }

    @Test
    void publish_canGetPublishedEvent() {
        assertThat(synchronousFakeEventBus.getReceivedEvents()).containsExactly(anEvent());
    }

    @Test
    void getEventOfType_returnsEvent() {
        assertThat(synchronousFakeEventBus.getEventOfType(VideoUpdated.class)).isEqualTo(anEvent());
    }

    @Test
    void getEventOfType_throws_whenMoreThanOneEventFound() {
        synchronousFakeEventBus.publish(anEvent());

        assertThatThrownBy(() -> synchronousFakeEventBus.getEventOfType(VideoUpdated.class));
    }

    @Test
    void getEventOfType_throws_whenNoEventFound() {
        synchronousFakeEventBus.clearState();

        assertThatThrownBy(() -> synchronousFakeEventBus.getEventOfType(VideoUpdated.class));
    }

    @Test
    void clear_clearsAllState() {
        synchronousFakeEventBus.clearState();

        assertThat(synchronousFakeEventBus.hasReceivedEventOfType(VideoUpdated.class)).isFalse();
    }

    @Test
    void countEventsOfType_returnsCount() {
        assertThat(synchronousFakeEventBus.countEventsOfType(VideoUpdated.class)).isEqualTo(1);
    }

    private VideoUpdated anEvent() {
        return VideoUpdated.builder().videoId("").contentPartnerName("").title("").build();
    }
}
