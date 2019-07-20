package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("videos-inclusion-from-stream-requested")
public class VideosInclusionInStreamRequested {

    @NonNull
    private List<String> videoIds;
}
