package com.boclips.eventbus.domain.collection;

import com.boclips.eventbus.domain.AgeRange;
import com.boclips.eventbus.domain.Subject;
import com.boclips.eventbus.domain.user.UserId;
import com.boclips.eventbus.domain.video.VideoId;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Collection {

    @NonNull
    private CollectionId id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private List<Subject> subjects;

    @NonNull
    private AgeRange ageRange;

    @NonNull
    private List<VideoId> videosIds;

    @NonNull
    private UserId ownerId;

    @NonNull
    private List<UserId> bookmarks;

    @NonNull
    private Boolean isDiscoverable;

    @NonNull
    private ZonedDateTime createdAt;

    @NonNull
    private ZonedDateTime updatedAt;
}
