package com.boclips.eventbus.events.order;

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
    private List<OrderItem> items;

    private OrderStatus status;
}
