package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.AbstractEventWithUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@BoclipsEvent("user-updated")
public class UserUpdated extends AbstractEventWithUser {
}
