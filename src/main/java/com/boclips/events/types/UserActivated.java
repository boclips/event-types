package com.boclips.events.types;

import com.boclips.events.types.base.Event;
import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated extends Event implements UserEvent {

    @NonNull
    private User user;

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
