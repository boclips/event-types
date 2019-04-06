package com.boclips.events.types;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysedVideoTopic {
    @NonNull
    private String name;

    @NonNull
    private String language;

    @NonNull
    Double confidence;

    @NonNull
    List<TimeSegment> segments;

    private AnalysedVideoTopic parent;
}
