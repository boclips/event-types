package com.boclips.eventbus.domain.user;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    @NonNull
    private ZonedDateTime createdAt;

    private String email;

    private Organisation organisation;

    @NonNull
    private Boolean isBoclipsEmployee;

    @NonNull
    private UserProfile profile;
}
