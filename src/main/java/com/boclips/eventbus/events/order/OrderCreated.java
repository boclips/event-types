package com.boclips.eventbus.events.order;

import com.boclips.eventbus.events.base.AbstractEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreated extends AbstractEvent {

    @NonNull
    private Order order;
}
