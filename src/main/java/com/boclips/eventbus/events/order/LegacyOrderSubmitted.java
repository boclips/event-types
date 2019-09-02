package com.boclips.eventbus.events.order;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent(value = "legacy-order-submitted")
public class LegacyOrderSubmitted {
    @NonNull
    private LegacyOrder order;

    @NonNull
    private List<LegacyOrderItem> orderItems;

    @NonNull
    private LegacyOrderUser requestingUser;

    @NonNull
    private LegacyOrderUser authorisingUser;
}
