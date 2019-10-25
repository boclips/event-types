package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUser;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@BoclipsEvent("user-created")
public class UserCreated extends AbstractEventWithUser {
}
