package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @NonNull
    private String name;

    @NonNull
    private String language;

    private Topic parent;
}
