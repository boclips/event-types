package com.boclips.eventbus.events.organisation;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.user.Organisation;
import com.boclips.eventbus.events.base.AbstractEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@BoclipsEvent("organisation-updated")
public class OrganisationUpdated extends AbstractEvent {
    @NonNull
    private Organisation organisation;
}
