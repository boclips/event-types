package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-updated")
public class VideoUpdated {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String contentPartnerName;

    @NonNull
    private List<String> subjects;

    private AgeRange ageRange;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class AgeRange {

        @NonNull
        private Integer min;

        private Integer max;
    }
}
