package com.boclips.events.types.video;

import com.boclips.events.types.Captions;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoAnalysed {

    @NonNull
    private String videoId;

    @NonNull
    private Locale language;

    @NonNull
    private String transcript;

    @NonNull
    private Captions captions;

    @NonNull
    private List<VideoAnalysedTopic> topics;

    @NonNull
    private List<VideoAnalysedKeyword> keywords;
}
