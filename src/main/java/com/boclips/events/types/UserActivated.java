package com.boclips.events.types;

import com.boclips.events.types.base.Event;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated extends Event {

    @NonNull
    private User user;

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
