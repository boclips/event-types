package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AbstractEventWithUserId extends AbstractEvent {
    @NonNull
    private String userId;

    @Deprecated
    private String overrideUserId;

    private String externalUserId;

    private String deviceId;
}
