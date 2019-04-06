package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
    @NonNull
    private String name;

    @NonNull
    private String language;
}
