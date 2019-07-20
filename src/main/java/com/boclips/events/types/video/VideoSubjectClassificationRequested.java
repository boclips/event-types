package com.boclips.events.types.video;

import com.boclips.events.BoclipsEvent;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-subject-classification-requested")
public class VideoSubjectClassificationRequested implements Serializable {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String description;
}
