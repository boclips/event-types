package com.boclips.eventbus;

import com.boclips.eventbus.events.video.VideoUpdated;
import com.boclips.eventbus.infrastructure.PubSubEventBus;
import com.boclips.eventbus.infrastructure.SynchronousEventBus;
import com.boclips.eventbus.testsupport.DemoApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@ActiveProfiles("test")
@SpringBootTest(classes = DemoApplication.class)
@ExtendWith(SpringExtension.class)
public class EventBusContractTest {

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void pubSubTest(EventBus eventBus) {
        AtomicReference<VideoUpdated> receivedEvent = new AtomicReference<>(null);

        eventBus.subscribe(VideoUpdated.class, receivedEvent::set);

        VideoUpdated event = VideoUpdated.builder()
                .videoId(UUID.randomUUID().toString())
                .title("the title")
                .contentPartnerName("the content partner")
                .build();

        eventBus.publish(event);

        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(receivedEvent.get()).isEqualTo(event)
        );
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
