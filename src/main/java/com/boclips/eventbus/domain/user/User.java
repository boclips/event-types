package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    private String organisationId;

    @NonNull
    private Boolean isBoclipsEmployee;
}
