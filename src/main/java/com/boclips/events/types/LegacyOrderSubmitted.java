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
public class LegacyOrderSubmitted {
    @NonNull
    private LegacyOrder order;

    @NonNull
    private List<LegacyOrderItem> orderItems;
}
