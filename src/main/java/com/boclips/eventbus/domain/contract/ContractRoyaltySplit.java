package com.boclips.eventbus.domain.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractRoyaltySplit {
    private Float download;
    private Float streaming;
}
