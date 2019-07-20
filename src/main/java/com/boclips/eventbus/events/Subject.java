package com.boclips.eventbus.events;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @NonNull
    private String id;
}
