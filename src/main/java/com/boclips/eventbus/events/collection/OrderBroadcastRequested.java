package com.boclips.eventbus.events.collection;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.order.Order;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("order-broadcast-requested")
public class OrderBroadcastRequested {

    @NonNull
    private Order order;
}
