package com.boclips.eventbus.events.contract;

import com.boclips.eventbus.domain.contract.Contract;
import com.boclips.eventbus.domain.contract.ContractId;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BroadcastContractRequestedTest {
    @Test
    void broadcastContractRequested_canBeDeserialized() {
        Contract contract = Contract.builder()
                .contractId(ContractId.builder().value("my-id").build())
                .name("contract")
                .build();
        BroadcastContractRequested event =
                BroadcastContractRequested.builder().contract(contract).build();
        EventSerializer serializer = new EventSerializer();

        Object deserialized = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserialized).isEqualTo(event);
    }
}
