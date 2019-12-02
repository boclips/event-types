package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEvent {

    @NonNull
    @Builder.Default
    private ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("UTC"));

    private String url;
}
