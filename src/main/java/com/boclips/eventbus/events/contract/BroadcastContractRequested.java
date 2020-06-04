package com.boclips.eventbus.events.contract;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.contract.Contract;
import com.boclips.eventbus.events.base.AbstractEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@BoclipsEvent("contract-broadcast-requested")
public class BroadcastContractRequested extends AbstractEvent {
    @NonNull
    private Contract contract;
}
