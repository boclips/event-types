package com.boclips.eventbus.domain.contentpartner;

import com.boclips.eventbus.domain.AgeRange;
import lombok.*;

import java.time.Period;
import java.util.List;
import java.util.Locale;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentPartner {
    @NonNull
    private ContentPartnerId id;

    @NonNull
    private String name;

    private ChannelTopLevelDetails details;

    private ChannelPedagogyDetails pedagogy;

    private ChannelIngestDetails ingest;

    private ChannelMarketingDetails marketing;

    @NonNull
    @Deprecated
    private AgeRange ageRange;

    @Deprecated
    private String legalRestrictions;

    @Deprecated
    private String description;

    @Deprecated
    private List<String> contentTypes;

    @Deprecated
    private List<String> contentCategories;

    @Deprecated
    private Locale language;

    @Deprecated
    private String hubspotId;

    @Deprecated
    private String awards;

    @Deprecated
    private String notes;

    @Deprecated
    private Period deliveryFrequency;
}