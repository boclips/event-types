package com.boclips.eventbus.events.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegacyOrderItemLicense {
    @NonNull
    private String id;

    @NonNull
    @JsonProperty("uuid")
    private String uuid;

    @NonNull
    @JsonProperty("date_updated")
    private Date dateUpdated;

    @NonNull
    @JsonProperty("date_created")
    private Date dateCreated;

    @NonNull
    private String code;

    @NonNull
    private String description;
}
