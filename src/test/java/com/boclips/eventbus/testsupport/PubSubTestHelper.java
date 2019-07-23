package com.boclips.eventbus.testsupport;

import com.boclips.eventbus.config.BoclipsEventsProperties;
import com.boclips.eventbus.infrastructure.PubSubEventBus;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.pubsub.v1.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PubSubTestHelper {

    private final PubSubEventBus pubSubEventBus;

    private final BoclipsEventsProperties boclipsEventsProperties;

    public PubSubTestHelper(PubSubEventBus pubSubEventBus, BoclipsEventsProperties boclipsEventsProperties) {
        this.pubSubEventBus = pubSubEventBus;
        this.boclipsEventsProperties = boclipsEventsProperties;
    }

    public void deleteSubscriptionsAndTopics() {
        String projectId = boclipsEventsProperties.getProject();
        try(SubscriptionAdminClient subscriptionAdmin = pubSubEventBus.subscriptionAdminClient()) {
            for (Subscription subscription : subscriptionAdmin.listSubscriptions(ProjectName.of(projectId)).iterateAll()) {
                System.out.println("Deleting subscription " + subscription.getName());
                subscriptionAdmin.deleteSubscription(subscription.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error trying to delete subscriptions from " + projectId, e);
        }
        try(TopicAdminClient topicAdmin = pubSubEventBus.topicAdminClient()) {
            for(Topic topic : topicAdmin.listTopics(ProjectName.of(projectId)).iterateAll()) {
                System.out.println("Deleting topic " + topic.getName());
                topicAdmin.deleteTopic(topic.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error trying to delete topics from " + projectId, e);
        }
    }
}
