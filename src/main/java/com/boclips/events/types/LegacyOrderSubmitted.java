package com.boclips.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class LegacyOrderItemLicense {
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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class LegacyOrderItem {
    @NonNull
    private String id;

    @NonNull
    @JsonProperty("uuid")
    private String uuid;

    @NonNull
    @JsonProperty("asset_id")
    private String assetId;

    @NonNull
    @JsonProperty("date_updated")
    private Date dateUpdated;

    @NonNull
    @JsonProperty("date_created")
    private Date dateCreated;

    @NonNull
    private LegacyOrderItemLicense license;

    @NonNull
    private BigDecimal price;

    @NonNull
    @JsonProperty("transcripts_required")
    private Boolean transcriptsRequired;

    @NonNull
    private String status;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LegacyOrderSubmitted {
    @NonNull
    private LegacyOrder order;

    @NonNull
    private List<LegacyOrderItem> orderItems;
}
