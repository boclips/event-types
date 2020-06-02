package com.boclips.eventbus.events.contract;

import com.boclips.eventbus.domain.contract.*;
import com.boclips.eventbus.infrastructure.EventSerializer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Currency;

import static org.assertj.core.api.Assertions.assertThat;

public class ContractUpdatedTest {
    @Test
    void contractUpdated_canBeDeserialized() {
        Contract contract = Contract.builder()
                .contractId(ContractId.builder().value("my-id").build())
                .name("contract")
                .contractDocument("http://cool.com")
                .contractIsRolling(true)
                .contractDates(
                        ContractDates.builder()
                                .start(LocalDate.ofYearDay(2012, 200))
                                .start(LocalDate.ofYearDay(2015, 250))
                                .build()
                )
                .daysBeforeTerminationWarning(30)
                .yearsForMaximumLicense(5)
                .daysForSellOffPeriod(60)
                .royaltySplit(ContractRoyaltySplit.builder()
                        .download(50.3F)
                        .streaming(20F)
                        .build())
                .minimumPriceDescription("Minimum price description")
                .remittanceCurrency(Currency.getInstance("GBP"))
                .restrictions(ContractRestrictions.builder()
                        .clientFacing(Collections.singletonList("client-face"))
                        .territory("territory")
                        .licensing("licensing")
                        .editing("editing")
                        .marketing("marketing")
                        .companies("companies")
                        .payout("payout")
                        .other("other")
                        .build())
                .costs(ContractCosts.builder()
                        .minimumGuarantee(Collections.singletonList(BigDecimal.TEN))
                        .upfrontLicense(BigDecimal.ONE)
                        .technicalFee(BigDecimal.ONE)
                        .recoupable(true)
                        .build())
                .build();
        ContractUpdated event =
                ContractUpdated.builder().contract(contract).build();
        EventSerializer serializer = new EventSerializer();

        Object deserialized = serializer.deserialise(event, serializer.serialise(event));

        assertThat(deserialized).isEqualTo(event);
    }
}
