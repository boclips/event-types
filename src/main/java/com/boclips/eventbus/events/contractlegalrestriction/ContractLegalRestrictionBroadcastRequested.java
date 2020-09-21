package com.boclips.eventbus.events.contractlegalrestriction;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.ContractLegalRestriction;
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
@BoclipsEvent("contract-legal-restriction-broadcast-requested")
public class ContractLegalRestrictionBroadcastRequested extends AbstractEvent {
    @NonNull
    private ContractLegalRestriction contractLegalRestriction;
}
