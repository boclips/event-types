package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.user.Organisation;
import com.boclips.eventbus.events.base.AbstractUserEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@BoclipsEvent("user-created")
public class UserCreated extends AbstractUserEvent {

    @NonNull
    private Organisation organisation;
}
