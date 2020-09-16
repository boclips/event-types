package com.boclips.eventbus.domain.contract;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractLegalRestriction {
    @NonNull
    private String id;
    @NonNull
    private String text;
}
