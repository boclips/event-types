package com.boclips.eventbus.domain.user;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deal {

    private ZonedDateTime expiresAt;

    @NonNull
    private Boolean billing;
}
