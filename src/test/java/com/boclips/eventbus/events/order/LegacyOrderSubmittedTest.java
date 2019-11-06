package com.boclips.eventbus.events.order;


import com.boclips.eventbus.testsupport.TestWithJsonFixture;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LegacyOrderSubmittedTest extends TestWithJsonFixture {
    @Test
    void objectMapperCanParseJsonIntoLegacyOrderSubmitted() throws IOException {
        String json = loadExample("legacy-order.json");

        LegacyOrderSubmitted event = new ObjectMapper().readValue(json, LegacyOrderSubmitted.class);

        assertThat(event.getOrder()).isEqualTo(
                LegacyOrder.builder()
                        .status("CONFIRMED")
                        .dateUpdated(Date.from(Instant.parse("2019-05-07T10:08:35.216Z")))
                        .dateCreated(Date.from(Instant.parse("2019-05-07T10:08:35.216Z")))
                        .extraFields(LegacyOrderExtraFields.builder()
                                .agreeTerms(true)
                                .isbnOrProductNumber("")
                                .build())
                        .id("5cd159236385cd23340811b3")
                        .uuid("5e4dd045-cbac-4f15-ae88-91d23d5dcee2")
                        .nextStatus(LegacyOrderNextStatus.builder()
                                .roles(Collections.singletonList("super"))
                                .nextStates(Arrays.asList("PROCESSING", "CANCELLED"))
                                .build())
                .build()
        );
        assertThat(event.getOrderItems()).isEqualTo(Arrays.asList(
                LegacyOrderItem.builder()
                        .id("5cd158e96385cd18c208119e")
                        .uuid("4b0cdd04-ba2f-450e-bfbd-8d27d708d9e3")
                        .assetId("5c542ac05438cdbcb56df2c3")
                        .dateUpdated(Date.from(Instant.parse("2019-05-07T10:08:36.028Z")))
                        .dateCreated(Date.from(Instant.parse("2019-05-07T10:07:37.431Z")))
                        .transcriptsRequired(true)
                        .status("OPEN")
                        .trimming("1 - 145")
                        .build(),
                LegacyOrderItem.builder()
                        .id("5cd158dcc5380897ad1aa329")
                        .uuid("714c50b4-fa58-463e-a374-81ac39996cf4")
                        .assetId("5c542ab95438cdbcb56de2ec")
                        .dateUpdated(Date.from(Instant.parse("2019-05-07T10:08:36.029Z")))
                        .dateCreated(Date.from(Instant.parse("2019-05-07T10:07:24.672Z")))
                        .transcriptsRequired(true)
                        .status("OPEN")
                        .trimming("")
                        .build()
        ));

        assertThat(event.getAuthorisingUser()).isEqualTo(
                LegacyOrderUser.builder()
                        .email("bo@bo.com")
                        .firstName("bo")
                        .lastName("obob")
                        .id("bob123")
                        .organisation(LegacyOrderOrganisation.builder()
                                .id("4bo5")
                                .name("QueenOfTheBos")
                                .build())
                        .username("thisObBo")
                        .build()
        );


        assertThat(event.getRequestingUser()).isEqualTo(
                LegacyOrderUser.builder()
                        .email("bo@bo.com")
                        .firstName("bo")
                        .lastName("obob")
                        .id("bob123")
                        .organisation(LegacyOrderOrganisation.builder()
                                .id("4bo5")
                                .name("QueenOfTheBos")
                                .build())
                        .username("thisObBo")
                        .build()
        );

    }
}
