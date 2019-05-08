package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated {

    @NonNull
    private String userId;

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
