package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organisation {

    @NonNull
    private String id;

    private Organisation parent;
}
