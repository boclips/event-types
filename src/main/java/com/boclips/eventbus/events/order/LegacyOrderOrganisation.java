package com.boclips.eventbus.events.order;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegacyOrderOrganisation {
    @NonNull
    private String id;

    @NonNull
    private String name;
}
