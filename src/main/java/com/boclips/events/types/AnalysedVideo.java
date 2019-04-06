package com.boclips.events.types;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysedVideo {

    @NonNull
    private String videoId;

    @NonNull
    private String language;

    @NonNull
    private String transcript;

    @NonNull
    private Captions captions;

    @NonNull
    private List<AssignedTopic> topics;

    @NonNull
    private List<AssignedKeyword> keywords;
}
