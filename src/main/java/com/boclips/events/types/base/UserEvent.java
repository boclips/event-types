package com.boclips.events.types.base;

import com.boclips.events.types.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent extends Event {

    @NonNull
    private User user;
}