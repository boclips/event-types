package com.boclips.eventbus.domain.video;

import com.boclips.eventbus.domain.AgeRange;
import com.boclips.eventbus.domain.Subject;
import com.boclips.eventbus.domain.contentpartner.ChannelId;
import lombok.*;

import java.time.LocalDate;
import java.time.ZonedDateTime;
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
    private ChannelId channelId;

    @NonNull
    private List<Subject> subjects;

    @NonNull
    private AgeRange ageRange;

    @NonNull
    private PlaybackProviderType playbackProviderType;

    @NonNull
    private Integer durationSeconds;

    @NonNull
    private VideoType type;

    @NonNull
    private List<VideoType> types;

    @NonNull
    private LocalDate releasedOn;

    @NonNull
    private ZonedDateTime ingestedAt;

    private Dimensions originalDimensions;

    private List<VideoAsset> assets;

    @NonNull
    private Boolean promoted;
}
