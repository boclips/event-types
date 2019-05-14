package com.boclips.events.types.base;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Event {

    @NonNull
    @Builder.Default
    private Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());

    private String url;
}
