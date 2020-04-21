package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    private String email;

    private Organisation organisation;

    @NonNull
    private Boolean isBoclipsEmployee;

    @NonNull
    private UserProfile profile;
}
