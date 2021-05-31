package com.boclips.eventbus.domain.contentpartner;

import lombok.*;

import java.time.Period;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelIngestDetails {

    @NonNull
    private String type;

    @Deprecated
    private List<String> urls;

    private Set<DistributionMethod> distributionMethods;
}
