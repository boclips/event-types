package com.boclips.eventbus.events.user;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.UserEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@BoclipsEvent("user-created")
public class UserCreated extends UserEvent {
}
