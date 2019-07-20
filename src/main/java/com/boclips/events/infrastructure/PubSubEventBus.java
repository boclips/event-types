package com.boclips.events.infrastructure;

import com.boclips.events.config.BoclipsEventsProperties;
import com.boclips.events.EventBus;
import com.boclips.events.config.EventConfigurationExtractor;
import com.boclips.events.config.EventListener;
import com.boclips.events.config.InvalidMessagingConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.rpc.NotFoundException;
import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.pubsub.v1.*;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PushConfig;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

@Component
public class PubSubEventBus implements EventBus {

    private final String projectId;
    private final String consumerGroup;
    private final ObjectMapper objectMapper;
    private final CredentialsProvider credentialsProvider;

    public PubSubEventBus(BoclipsEventsProperties properties, ObjectMapper objectMapper) {
        validateConfig(properties);

        this.objectMapper = objectMapper;
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
    public void subscribe(EventListener eventListener) {

        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectId, eventListener.getTopic() + "." + consumerGroup);

        try {
            createSubscription(subscriptionName, eventListener.getTopic());
        } catch (IOException e) {
            throw new RuntimeException("Could not create subscription", e);
        }

        MessageReceiver receiver =
                (message, consumer) -> {
                    try {
                        Object payload = objectMapper.readValue(message.getData().toStringUtf8(), eventListener.getEventType());
                        eventListener.receive(payload);

                    } catch (Exception e) {
                        e.printStackTrace();

                    } finally {
                        consumer.ack();
                    }
                };

        Subscriber subscriber = Subscriber
                .newBuilder(subscriptionName, receiver)
                .setCredentialsProvider(credentialsProvider)
                .build();

        subscriber.startAsync();
    }

    private void createSubscription(ProjectSubscriptionName subscriptionName, String topicId) throws IOException {
        SubscriptionAdminSettings subscriptionAdminSettings = SubscriptionAdminSettings.newBuilder()
                .setCredentialsProvider(credentialsProvider).build();
        SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings);

        if (subscriptionDoesNotExist(subscriptionAdminClient, subscriptionName)) {
            ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);
            subscriptionAdminClient.createSubscription(subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
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

    @Override
    public void publish(Object event) {
        String topicName = new EventConfigurationExtractor().getEventName(event.getClass());
        ProjectTopicName topic = ProjectTopicName.of(projectId, topicName);
        try {
            Publisher publisher = Publisher.newBuilder(topic).setCredentialsProvider(credentialsProvider).build();
            byte[] eventBytes = objectMapper.writeValueAsBytes(event);
            ByteString eventByteString = ByteString.copyFrom(eventBytes);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(eventByteString).build();
            publisher.publish(pubsubMessage).get();
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to publish a " + topic + " event", e);
        }
    }

    private static void validateConfig(BoclipsEventsProperties properties) {
        String consumerGroup = properties.getConsumerGroup();
        if (consumerGroup == null || consumerGroup.isEmpty()) {
            throw new IllegalArgumentException("PUBSUB_CONSUMER_GROUP must be defined");
        }

        String projectId = properties.getProject();
        if (projectId == null || projectId.isEmpty()) {
            throw new IllegalArgumentException("PUBSUB_PROJECT_ID must be defined");
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
}
