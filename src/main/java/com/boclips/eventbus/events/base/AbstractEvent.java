package com.boclips.eventbus.events.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractEvent {

    @NonNull
    @Builder.Default
    private Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());

    private String url;
}
