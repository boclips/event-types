package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organisation {

    @NonNull
    private String id;

    @NonNull
    private String type;

    @NonNull
    private String name;

    private String postcode;

    private Organisation parent;
}
