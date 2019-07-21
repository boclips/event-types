package com.boclips.eventbus.events.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @NonNull
    private String id;
}
