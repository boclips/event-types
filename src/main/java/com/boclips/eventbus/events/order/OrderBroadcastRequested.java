package com.boclips.eventbus.events.order;

import com.boclips.eventbus.BoclipsEvent;
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
