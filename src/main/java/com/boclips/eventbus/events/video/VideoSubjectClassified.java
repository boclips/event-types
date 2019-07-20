package com.boclips.eventbus.events.video;

import com.boclips.eventbus.BoclipsEvent;
import com.boclips.eventbus.events.Subject;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@BoclipsEvent("video-subject-classified")
public class VideoSubjectClassified implements Serializable {

    @NonNull
    private String videoId;

    @NonNull
    private Set<Subject> subjects;
}
