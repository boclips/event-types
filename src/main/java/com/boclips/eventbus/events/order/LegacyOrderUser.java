package com.boclips.eventbus.events.order;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegacyOrderUser {
    @NonNull
    private String id;

    @NonNull
    private String email;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String username;

    @NonNull
    private LegacyOrderOrganisation organisation;
}
