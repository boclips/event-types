package com.boclips.events.types;

import com.boclips.events.BoclipsEvent;
import com.boclips.events.types.base.UserEvent;
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
