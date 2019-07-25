package com.boclips.eventbus.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @NonNull
    private SubjectId id;

    @NonNull
    private String name;

}
