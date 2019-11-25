package com.boclips.eventbus.events.order;

import com.boclips.eventbus.domain.video.VideoId;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NonNull
    private String id;

    @NonNull
    private Date dateUpdated;

    @NonNull
    private Date dateCreated;

    @NonNull
    private List<VideoId> videoIds;
}
