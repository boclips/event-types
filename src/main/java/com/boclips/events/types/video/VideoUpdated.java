package com.boclips.events.types.video;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VideoUpdated {

    @NonNull
    private String videoId;

    @NonNull
    private String title;

    @NonNull
    private String contentPartnerName;
}
