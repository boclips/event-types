package com.boclips.eventbus.infrastructure;

import com.boclips.eventbus.ConflictingSubscriberException;
import com.boclips.eventbus.EventBus;
import com.boclips.eventbus.EventHandler;
import com.boclips.eventbus.config.BoclipsEventsProperties;
import com.boclips.eventbus.config.EventConfigurationExtractor;
import com.boclips.eventbus.config.InvalidMessagingConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.NotFoundException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.pubsub.v1.*;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import org.threeten.bp.Duration;

import javax.annotation.PreDestroy;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@ConditionalOnMissingBean(EventBus.class)
public class PubSubEventBus implements EventBus {
    private final Logger logger = Logger.getLogger(PubSubEventBus.class.getName());
    private final String projectId;
    private final String consumerGroup;
    private final ObjectMapper objectMapper;
    private final CredentialsProvider credentialsProvider;
    private final Map<Class<?>, Subscriber> subscriberByEventType = new HashMap<>();
    private final Map<String, Publisher> publisherByTopic = new HashMap<>();

    private final BatchingSettings publisherBatchingSettings = BatchingSettings.newBuilder()
            .setElementCountThreshold(200L)
            .setRequestByteThreshold(10000L)
            .setDelayThreshold(Duration.ofSeconds(1))
            .build();

    public PubSubEventBus(BoclipsEventsProperties properties) {
        validateConfig(properties);

        this.objectMapper = ObjectMapperProvider.get();
        this.projectId = properties.getProject();
        this.consumerGroup = properties.getConsumerGroup();

        try {
            InputStream secretStream = new ByteArrayInputStream(Base64.getDecoder().decode(properties.getSecret()));
            Credentials credentials = ServiceAccountCredentials.fromStream(secretStream);
            this.credentialsProvider = FixedCredentialsProvider.create(credentials);
        } catch (IOException e) {
            throw new IllegalArgumentException("PUBSUB_SECRET is invalid");
        }
    }

    @Override
    public <T> void subscribe(Class<T> eventType, EventHandler<T> eventHandler) {
        subscriberByEventType.computeIfPresent(eventType, (cls, subscriber) -> {
            throw new ConflictingSubscriberException("There already is a subscription for " + eventType.getSimpleName());
        });

        String topicName = new EventConfigurationExtractor().getEventName(eventType);

        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectId, topicName + "." + consumerGroup);

        try {
            createSubscription(subscriptionName, topicName);
        } catch (IOException e) {
            throw new RuntimeException("Could not create subscription", e);
        }

        MessageReceiver receiver =
                (message, consumer) -> {
                    try {
                        T payload = objectMapper.readValue(message.getData().toStringUtf8(), eventType);
                        eventHandler.handle(payload);
                    } catch (Exception e) {
                        logger.severe("Error handling message from " + subscriptionName.toString() + ": " + e.getMessage());
                        e.printStackTrace();
                    } finally {
                        consumer.ack();
                    }
                };

        Subscriber subscriber = Subscriber
                .newBuilder(subscriptionName, receiver)
                .setCredentialsProvider(credentialsProvider)
                .build();

        subscriberByEventType.put(eventType, subscriber);

        subscriber.startAsync().awaitRunning();
        logger.info(String.format("Started listening on %s", eventType));
    }

    @Override
    public <T> void publish(T event) {
        publish(Collections.singletonList(event));
    }

    @Override
    public <T> void publish(Iterable<T> events) {
        String topicName = new EventConfigurationExtractor().getEventName(events.iterator().next().getClass());

        logger.fine("Obtaining publisher for " + topicName);
        Publisher publisher = getPublisherFor(topicName);
        logger.fine("Obtained publisher for " + topicName);
        try {
            for (T event : events) {
                logger.fine("Serializing event...");
                byte[] eventBytes = objectMapper.writeValueAsBytes(event);
                ByteString eventByteString = ByteString.copyFrom(eventBytes);
                PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(eventByteString).build();
                logger.fine("Serialized event. Publishing...");
                publisher.publish(pubsubMessage);
                logger.fine("Published");
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to publish a " + topicName + " event", e);
        }
        logger.fine("Done publishing batch");
    }


    @Override
    public void unsubscribe(Class<?> eventType) {
        subscriberByEventType.remove(eventType);
    }

    private synchronized Publisher getPublisherFor(String topicName) {
        return publisherByTopic.computeIfAbsent(topicName, key -> {
            try {
                ProjectTopicName topic = createTopicIfDoesNotExist(topicName);
                return Publisher
                        .newBuilder(topic)
                        .setCredentialsProvider(credentialsProvider)
                        .setBatchingSettings(publisherBatchingSettings)
                        .build();
            } catch (IOException e) {
                throw new IllegalStateException(String.format("Failed to create publisher for %s", topicName));
            }
        });
    }

    private void createSubscription(ProjectSubscriptionName subscriptionName, String topicId) throws IOException {

        ProjectTopicName topicName = createTopicIfDoesNotExist(topicId);

        try (SubscriptionAdminClient subscriptionAdmin = subscriptionAdminClient()) {
            if (subscriptionDoesNotExist(subscriptionAdmin, subscriptionName)) {
                Subscription subscription = subscriptionAdmin.createSubscription(subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
                logger.info(String.format("Created subscription %s", subscription.getName()));
            }
        }
    }

    public TopicAdminClient topicAdminClient() throws IOException {
        TopicAdminSettings topicAdminSettings = TopicAdminSettings
                .newBuilder()
                .setCredentialsProvider(credentialsProvider)
                .build();
        return TopicAdminClient.create(topicAdminSettings);
    }

    public SubscriptionAdminClient subscriptionAdminClient() throws IOException {
        SubscriptionAdminSettings subscriptionAdminSettings = SubscriptionAdminSettings
                .newBuilder()
                .setCredentialsProvider(credentialsProvider)
                .build();
        return SubscriptionAdminClient.create(subscriptionAdminSettings);
    }

    private ProjectTopicName createTopicIfDoesNotExist(String topicId) throws IOException {
        ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
        try (TopicAdminClient topicAdmin = topicAdminClient()) {
            if (topicDoesNotExist(topicAdmin, topicName)) {
                Topic topic = topicAdmin.createTopic(topicName);
                logger.info(String.format("Created topic %s", topic.getName()));
            }
        }
        return topicName;
    }

    private boolean topicDoesNotExist(TopicAdminClient topicAdminClient, ProjectTopicName topicName) {
        try {
            logger.fine("Checking if topic " + topicName + " exists");
            topicAdminClient.getTopic(topicName);
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }

    private boolean subscriptionDoesNotExist(SubscriptionAdminClient subscriptionAdminClient, ProjectSubscriptionName subscriptionName) {
        try {
            subscriptionAdminClient.getSubscription(subscriptionName);
            return false;
        } catch (NotFoundException e) {
            return true;
        }
    }

    private static void validateConfig(BoclipsEventsProperties properties) {
        String consumerGroup = properties.getConsumerGroup();
        if (consumerGroup == null || consumerGroup.isEmpty()) {
            throw new IllegalArgumentException("PUBSUB_CONSUMER_GROUP must be defined");
        }

        String projectId = properties.getProject();
        if (projectId == null || projectId.isEmpty()) {
            throw new IllegalArgumentException("PUBSUB_PROJECT must be defined");
        }

        String secret = properties.getSecret();
        if (properties.getSecret() == null) {
            throw new InvalidMessagingConfiguration("PUBSUB_SECRET must be defined");
        }

        try {
            Base64.getDecoder().decode(secret);
        } catch (IllegalArgumentException e) {
            throw new InvalidMessagingConfiguration("PUBSUB_SECRET is not a base64-encoded string");
        }
    }

    @PreDestroy
    public void closeSubscriptionsAndPublishers() {
        subscriberByEventType.forEach((key, subscriber) -> {
            try {
                subscriber.stopAsync().awaitTerminated();
                logger.info(String.format("Closed subscription for %s [%s]", key, subscriber.state()));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e, () -> "Error shutting down subscriber for " + key);
            }
        });
        publisherByTopic.forEach((key, publisher) -> {
            try {
                publisher.shutdown();
                logger.info(String.format("Shutdown publisher for %s", key));
            } catch (Exception e) {
                logger.log(Level.SEVERE, e, () -> "Error shutting down publisher for " + key);
            }

        });
    }
}
