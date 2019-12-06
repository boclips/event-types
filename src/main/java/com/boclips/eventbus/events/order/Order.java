package com.boclips.eventbus.events.order;

import com.boclips.eventbus.domain.video.VideoId;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private String id;

    @NonNull
    private String customerOrganisationName;

    @NonNull
    private ZonedDateTime updatedAt;

    @NonNull
    private ZonedDateTime createdAt;

    @NonNull
    private List<VideoId> videoIds;

    @NonNull
    private List<OrderItem> items;
}
