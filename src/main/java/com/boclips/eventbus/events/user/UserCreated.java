package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.user.Organisation;
import com.boclips.eventbus.events.base.AbstractUserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@BoclipsEvent("user-created")
public class UserCreated extends AbstractUserEvent {

    private Organisation organisation;
}
