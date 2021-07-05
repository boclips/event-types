package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.domain.video.Captions;
import com.boclips.eventbus.domain.video.VideoAnalysedKeyword;
import com.boclips.eventbus.domain.video.VideoAnalysedTopic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-analysis-failed")
public class VideoAnalysisFailed {

    @NonNull
    private String videoId;
}
