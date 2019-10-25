package com.boclips.eventbus.events.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegacyOrderExtraFields {
    private Boolean agreeTerms;

    @JsonProperty("isbn_or_product_number")
    private String isbnOrProductNumber;
}
