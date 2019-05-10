package com.boclips.events.types;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivated {

    @NonNull
    private User user;

    @NonNull
    private Date timestamp;

    @NonNull
    private Long totalUsers;

    @NonNull
    private Long activatedUsers;
}
