package com.boclips.eventbus.domain.contentpartner;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
    @NonNull
    private ChannelId id;

    @NonNull
    private String name;

    private ChannelTopLevelDetails details;

    private ChannelPedagogyDetails pedagogy;

    private ChannelIngestDetails ingest;

    private ChannelMarketingDetails marketing;
}
