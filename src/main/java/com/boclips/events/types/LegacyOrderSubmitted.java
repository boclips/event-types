package com.boclips.events.types;

import lombok.*;

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

    @NonNull
    private String creator;

    @NonNull
    private String vendor;
}
