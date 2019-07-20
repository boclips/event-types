package com.boclips.events.config;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.BoclipsEventListener;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoclipsEventConfigurationExtractorTest {
    @BoclipsEvent("messaging-configurer-test-topic")
    private class TestPayload { }

    private class TestPayloadWithoutTopicAnnotation {}

    @BoclipsEvent("")
    private class TestPayloadWithBlankTopicName {}

    private EventConfigurationExtractor eventConfigurationExtractor = new EventConfigurationExtractor();

    @Test
    public void getTopicName_returnsTopicNameForGivenMessageType() {
        String topicName = eventConfigurationExtractor.getEventName(TestPayload.class);

        assertThat(topicName).isEqualTo("messaging-configurer-test-topic");
    }

    @Test
    public void getTopicName_whenMessageTypeIsNotAnnotatedWithTopic_throws() {
        assertThatThrownBy(() -> eventConfigurationExtractor.getEventName(TestPayloadWithoutTopicAnnotation.class))
                .isInstanceOf(InvalidMessagingConfiguration.class);
    }

    @Test
    public void getTopicName_whenTopicNameIBlank_throws() {
        assertThatThrownBy(() -> eventConfigurationExtractor.getEventName(TestPayloadWithBlankTopicName.class))
                .isInstanceOf(InvalidMessagingConfiguration.class);
    }

    static class TestListener {

        @BoclipsEventListener
        public void onEvent(TestPayload eventPayload) {

        }
    }

    @Test
    public void getListenerMethods_returnsAnnotatedMethods() throws NoSuchMethodException {
        List<EventConfigurationExtractor.ListenerMethodInfo> listenerMethods = eventConfigurationExtractor.getListenerMethods(new TestListener());

        Method expectedListenerMethod = TestListener.class.getMethod("onEvent", TestPayload.class);

        assertThat(listenerMethods).hasSize(1);
        assertThat(listenerMethods.get(0).getMethod()).isEqualTo(expectedListenerMethod);
        assertThat(listenerMethods.get(0).getEventType()).isEqualTo(TestPayload.class);
        assertThat(listenerMethods.get(0).getEventName()).isEqualTo("messaging-configurer-test-topic");
    }

}
