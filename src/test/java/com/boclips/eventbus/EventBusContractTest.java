package com.boclips.eventbus;

import com.boclips.eventbus.events.video.VideoAnalysisRequested;
import com.boclips.eventbus.infrastructure.PubSubEventBus;
import com.boclips.eventbus.infrastructure.SynchronousEventBus;
import com.boclips.eventbus.testsupport.AbstractSpringIntegrationTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.awaitility.Awaitility.await;

public class EventBusContractTest extends AbstractSpringIntegrationTest {

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void pubSubTest(EventBus eventBus) {
        TestEventHandler<VideoAnalysisRequested> handler = new TestEventHandler<>();
        eventBus.subscribe(VideoAnalysisRequested.class, handler);

        VideoAnalysisRequested event = VideoAnalysisRequested.builder()
                .videoId("1")
                .videoUrl("url")
                .build();

        eventBus.publish(event);

        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(handler.getEvents()).containsExactly(event)
        );

        eventBus.unsubscribe(VideoAnalysisRequested.class);
    }

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void subscribing_whenTopicAlreadySubscribedTo_throws(EventBus eventBus) {
        eventBus.subscribe(VideoAnalysisRequested.class, new TestEventHandler<>());

        assertThatThrownBy(() -> eventBus.subscribe(VideoAnalysisRequested.class, new TestEventHandler<>()))
                .isInstanceOf(ConflictingSubscriberException.class)
                .hasMessageContaining(VideoAnalysisRequested.class.getSimpleName());

        eventBus.unsubscribe(VideoAnalysisRequested.class);
    }
}

class EventBusArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new SynchronousEventBus()),
                Arguments.of(SpringExtension.getApplicationContext(context).getBean(PubSubEventBus.class))
        );
    }
}
