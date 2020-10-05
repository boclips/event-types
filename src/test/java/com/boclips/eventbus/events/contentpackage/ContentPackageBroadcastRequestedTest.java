package com.boclips.eventbus.events.contentpackage;

import com.boclips.eventbus.domain.contentpackage.ContentPackage;
import com.boclips.eventbus.domain.contentpackage.ContentPackageId;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContentPackageBroadcastRequestedTest {
    @Test
    void contractBroadcastRequested_canBeDeserialized() {
        ContentPackage contentPackage = ContentPackage
                .builder()
                .id(
                        ContentPackageId.builder()
                                .value("content-package-id")
                                .build()
                )
                .name("content-package")
                .build();
        ContentPackageBroadcastRequested event =
                ContentPackageBroadcastRequested.builder().contentPackage(contentPackage).build();
        EventSerializer serializer = new EventSerializer();

        Object deserialized = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserialized).isEqualTo(event);
    }
}
