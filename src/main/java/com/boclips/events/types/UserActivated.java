package com.boclips.events.types;

import lombok.*;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated {

    @NonNull
    private User user;

    @NonNull
    @Builder.Default
    private Date timestamp = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant());

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
