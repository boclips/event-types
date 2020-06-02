package com.boclips.eventbus.domain.contract;

import lombok.*;

import java.util.Currency;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @NonNull
    private ContractId contractId;

    @NonNull
    private String name;

    private String contractDocument;
    private Boolean contractIsRolling;
    private ContractDates contractDates;
    private Integer daysBeforeTerminationWarning;
    private Integer yearsForMaximumLicense;
    private Integer daysForSellOffPeriod;
    private ContractRoyaltySplit royaltySplit;
    private String minimumPriceDescription;
    private Currency remittanceCurrency;
    private ContractRestrictions restrictions;
    private ContractCosts costs;
}
