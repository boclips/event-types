package com.boclips.eventbus.domain.user;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarketingTracking {
    private String utmSource;
    private String utmContent;
    private String utmTerm;
    private String utmMedium;
    private String utmCampaign;
}
