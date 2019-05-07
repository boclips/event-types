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
class LegacyOrderExtraFields {
    private Boolean agreeTerms;

    @JsonProperty("isbn_or_product_number")
    private String isbnOrProductNumber;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class LegacyOrderNextStatus {
    @NonNull
    private List<String> roles;

    @NonNull
    @JsonProperty("next_states")
    private List<String> nextStates;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
class LegacyOrder {
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
