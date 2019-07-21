package com.boclips.eventbus.events.video;

import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class VideoAnalysedTopic {
    @NonNull
    Double confidence;
    @NonNull
    List<TimeSegment> segments;
    @NonNull
    private String name;
    @NonNull
    private Locale language;
    private VideoAnalysedTopic parent;
}
