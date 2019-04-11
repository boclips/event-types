package com.boclips.events.types;

import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysedVideo {

    @NonNull
    private String videoId;

    @NonNull
    private Locale language;

    @NonNull
    private String transcript;

    @NonNull
    private Captions captions;

    @NonNull
    private List<AnalysedVideoTopic> topics;

    @NonNull
    private List<AnalysedVideoKeyword> keywords;
}
