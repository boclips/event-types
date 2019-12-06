package com.boclips.eventbus.events.order;

import com.boclips.eventbus.domain.video.VideoId;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @NonNull VideoId videoId;

    @NonNull BigDecimal priceGbp;
}
