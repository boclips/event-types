package com.boclips.eventbus.events.order;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Currency;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private String id;

    private String legacyOrderId;

    @NonNull
    private String customerOrganisationName;

    @NonNull
    private ZonedDateTime updatedAt;

    @NonNull
    private ZonedDateTime createdAt;

    private ZonedDateTime deliveredAt;

    @NonNull
    private List<OrderItem> items;

    private OrderStatus status;

    private OrderUser authorisingUser;

    @NonNull
    private OrderUser requestingUser;

    private String isbnOrProductNumber;

    private OrderSource orderSource;

    private Currency currency;

    private BigDecimal fxRateToGbp;
}
