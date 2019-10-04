package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEventWithUserId extends AbstractEvent {

    @NonNull
    private String userId;
}
