package com.boclips.eventbus.events;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    @NonNull
    private Boolean isBoclipsEmployee;
}
