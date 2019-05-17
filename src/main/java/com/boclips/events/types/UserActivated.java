package com.boclips.events.types;

import com.boclips.events.types.base.UserEvent;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated extends UserEvent {

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
