package com.boclips.eventbus.events.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegacyOrder {
    @NonNull
    private String id;

    @NonNull
    @JsonProperty("uuid")
    private String uuid;

    @NonNull
    private String status;

    @NonNull
    @JsonProperty("date_updated")
    private ZonedDateTime dateUpdated;

    @NonNull
    @JsonProperty("date_created")
    private ZonedDateTime dateCreated;

    @NonNull
    @JsonProperty("extra_fields")
    private LegacyOrderExtraFields extraFields;

    @NonNull
    @JsonProperty("next_status")
    private LegacyOrderNextStatus nextStatus;
}
