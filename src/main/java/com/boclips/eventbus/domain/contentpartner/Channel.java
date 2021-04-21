package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.category.CategoryWithAncestors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

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

    @Deprecated
    private String legalRestrictions;

    private Set<CategoryWithAncestors> categories;
}
