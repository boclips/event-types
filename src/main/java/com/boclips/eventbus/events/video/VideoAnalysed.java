package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.video.Captions;
import com.boclips.eventbus.domain.video.VideoAnalysedKeyword;
import com.boclips.eventbus.domain.video.VideoAnalysedTopic;
import lombok.*;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-analysed")
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
