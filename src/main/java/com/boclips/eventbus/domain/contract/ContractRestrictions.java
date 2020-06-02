package com.boclips.eventbus.domain.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractRestrictions {
    private List<String> clientFacing;
    private String territory;
    private String licensing;
    private String editing;
    private String marketing;
    private String companies;
    private String payout;
    private String other;
}
