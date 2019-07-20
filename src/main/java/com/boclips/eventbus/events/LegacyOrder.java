package com.boclips.eventbus.events;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

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
    private String vendor;

    @NonNull
    private String creator;

    @NonNull
    @JsonProperty("date_updated")
    private Date dateUpdated;

    @NonNull
    @JsonProperty("date_created")
    private Date dateCreated;

    @NonNull
    @JsonProperty("extra_fields")
    private LegacyOrderExtraFields extraFields;

    @NonNull
    @JsonProperty("next_status")
    private LegacyOrderNextStatus nextStatus;
}
