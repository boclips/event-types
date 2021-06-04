package com.boclips.eventbus;

import com.boclips.eventbus.domain.contentpartner.Channel;
import com.boclips.eventbus.domain.contentpartner.ChannelId;
import com.boclips.eventbus.domain.video.ContentPartner;
import com.boclips.eventbus.events.contentpartner.ContentPartnerUpdated;
import com.boclips.eventbus.events.video.VideoAnalysisRequested;
import com.boclips.eventbus.events.video.VideoTranscriptCreated;
import com.boclips.eventbus.infrastructure.PubSubEventBus;
import com.boclips.eventbus.infrastructure.SynchronousFakeEventBus;
import com.boclips.eventbus.testsupport.AbstractPubSubTest;
import com.boclips.eventbus.testsupport.PubSubTestHelper;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.*;
import static org.awaitility.Awaitility.await;

public class EventBusContractTest extends AbstractPubSubTest {

    private VideoAnalysisRequested videoAnalysisRequested = VideoAnalysisRequested.builder()
            .videoId("1")
            .videoUrl("url")
            .build();

    private VideoTranscriptCreated videoTranscriptCreated = VideoTranscriptCreated.builder()
            .videoId("1")
            .transcript("bla bla bla")
            .build();

    private ContentPartnerUpdated contentPartnerUpdated = ContentPartnerUpdated.builder()
            .contentPartner(Channel.builder().id(ChannelId.builder().value("test").build()).name("test").build())
            .build();

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void subscription_whenEventPublished_receivesTheEvent(EventBus eventBus) {
        TestEventHandler<VideoAnalysisRequested> handler = new TestEventHandler<>();
        eventBus.subscribe(VideoAnalysisRequested.class, handler, "VideoAnalysisRequestedHandler");

        eventBus.publish(videoAnalysisRequested);

        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(handler.getEvents()).containsExactly(videoAnalysisRequested)
        );

        eventBus.unsubscribe(VideoAnalysisRequested.class);
    }

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void subscription_whenMultipleHandlers_receivesTheEvent(EventBus eventBus) {
        TestEventHandler<ContentPartnerUpdated> handler1 = new TestEventHandler<>();
        TestEventHandler<ContentPartnerUpdated> handler2 = new TestEventHandler<>();

        eventBus.subscribe(ContentPartnerUpdated.class, handler1, "handler1");
        eventBus.subscribe(ContentPartnerUpdated.class, handler2, "handler2");

        eventBus.publish(contentPartnerUpdated);

        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(handler1.getEvents()).containsExactly(contentPartnerUpdated)
        );
        await().atMost(5, SECONDS).untilAsserted(() ->
                assertThat(handler2.getEvents()).containsExactly(contentPartnerUpdated)
        );

        eventBus.unsubscribe(ContentPartnerUpdated.class);
    }

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void subscribing_whenTopicAlreadySubscribedTo_throws(EventBus eventBus) {
        eventBus.subscribe(VideoAnalysisRequested.class, new TestEventHandler<>(), "handler");

        assertThatThrownBy(() -> eventBus.subscribe(VideoAnalysisRequested.class, new TestEventHandler<>(), "handler"))
                .isInstanceOf(ConflictingSubscriberException.class)
                .hasMessageContaining(VideoAnalysisRequested.class.getSimpleName());

        eventBus.unsubscribe(VideoAnalysisRequested.class);
    }

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void publishing_whenNoSubscriptions_doesNotThrow(EventBus eventBus) {
        assertThatCode(() -> {
            eventBus.publish(new EventNooneSubscribesTo());
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ArgumentsSource(EventBusArgumentProvider.class)
    void bulkPublishing_whenDifferentClasses_throws(EventBus eventBus) {
        assertThatThrownBy(() -> {
            eventBus.publish(Arrays.asList(
                    videoAnalysisRequested,
                    videoTranscriptCreated
            ));
        })
                .hasMessageContaining("the same class");
    }

    @BoclipsEvent("noone-subscribed-to-this")
    static class EventNooneSubscribesTo {
        public String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}

class EventBusArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        PubSubEventBus pubSubEventBus = SpringExtension.getApplicationContext(context).getBean(PubSubEventBus.class);
        PubSubTestHelper pubSubTestHelper = SpringExtension.getApplicationContext(context).getBean(PubSubTestHelper.class);
        pubSubTestHelper.deleteSubscriptionsAndTopics();

        SynchronousFakeEventBus synchronousFakeEventBus = new SynchronousFakeEventBus();

        return Stream.of(
                Arguments.of(pubSubEventBus),
                Arguments.of(synchronousFakeEventBus)
        );
    }
}

class TestEventHandler<T> implements EventHandler<T> {
    private final List<T> events = new ArrayList<>();

    @Override
    public void handle(T event) {
        events.add(event);
    }

    public List<T> getEvents() {
        return events;
    }
}
