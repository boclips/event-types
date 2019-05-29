package com.boclips.events.types.video;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoSubjectClassificationRequested implements Serializable {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String description;
}
