package com.boclips.eventbus.domain.video;

import com.boclips.eventbus.domain.AgeRange;
import com.boclips.eventbus.domain.Subject;
import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @NonNull
    private VideoId id;

    @NonNull
    private String title;

    @NonNull
    private ContentPartner contentPartner;

    @NonNull
    private List<Subject> subjects;

    @NonNull
    private AgeRange ageRange;

    @NonNull
    private PlaybackProviderType playbackProviderType;
}
