package com.boclips.events.types;

import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VideoAnalysedTopic {
    @NonNull
    private String name;

    @NonNull
    private Locale language;

    @NonNull
    Double confidence;

    @NonNull
    List<TimeSegment> segments;

    private VideoAnalysedTopic parent;
}