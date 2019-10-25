package com.boclips.eventbus.events.base;

import com.boclips.eventbus.domain.user.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEventWithUser extends AbstractEvent {

    @NonNull
    private User user;
}