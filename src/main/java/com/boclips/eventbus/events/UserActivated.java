package com.boclips.eventbus.events;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("user-activated")
public class UserActivated extends UserEvent {

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
