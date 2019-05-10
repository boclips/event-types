package com.boclips.events.types;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @NonNull
    private String id;

    @NonNull
    private String email;
}
