package com.boclips.eventbus.domain.contract;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @NonNull
    private ContractId contractId;

    private String name;
}
