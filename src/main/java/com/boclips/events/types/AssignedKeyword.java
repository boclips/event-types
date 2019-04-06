package com.boclips.events.types;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignedKeyword {
    @NonNull
    Keyword value;

    @NonNull
    Double confidence;

    @NonNull
    List<TimeSegment> segments;
}
