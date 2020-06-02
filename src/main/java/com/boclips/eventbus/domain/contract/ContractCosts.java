package com.boclips.eventbus.domain.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractCosts {
    private List<BigDecimal> minimumGuarantee;
    private BigDecimal upfrontLicense;
    private BigDecimal technicalFee;
    private Boolean recoupable;
}
