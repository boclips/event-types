package com.boclips.events.types;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LegacyOrderSubmittedTest extends TestWithJsonFixture {
    @Test
    void objectMapperCanParseJsonIntoLegacyOrderSubmitted() throws IOException {
        String json = loadExample("legacy-order.json");

        LegacyOrderSubmitted event = new ObjectMapper().readValue(json, LegacyOrderSubmitted.class);

        assertThat(event.getCreator()).isEqualTo("somecreator@boclips.com");
        assertThat(event.getVendor()).isEqualTo("somevendor@boclips.com");
        assertThat(event.getOrder()).isEqualTo(
                LegacyOrder.builder()
                        .status("CONFIRMED")
                        .vendor("5bb49b8dc939fc45e4e5cd8d")
                        .creator("5bb49b8dc939fc45e4e5cd8d")
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
                        .license(
                                LegacyOrderItemLicense.builder()
                                        .id("5bb49b91c939fc45e4e5cdbc")
                                        .uuid("0cbf8361-55c4-3fcc-1c6c-dc2c3d623f3f")
                                        .dateCreated(Date.from(Instant.parse("2018-10-03T10:36:01.535Z")))
                                        .dateUpdated(Date.from(Instant.parse("2018-10-03T10:36:01.535Z")))
                                        .code("10YR_SR")
                                        .description("Term 10 year Single Region")
                                        .build()
                        )
                        .price(new BigDecimal("1000.00"))
                        .transcriptsRequired(true)
                        .status("OPEN")
                        .build(),
                LegacyOrderItem.builder()
                        .id("5cd158dcc5380897ad1aa329")
                        .uuid("714c50b4-fa58-463e-a374-81ac39996cf4")
                        .assetId("5c542ab95438cdbcb56de2ec")
                        .dateUpdated(Date.from(Instant.parse("2019-05-07T10:08:36.029Z")))
                        .dateCreated(Date.from(Instant.parse("2019-05-07T10:07:24.672Z")))
                        .license(
                                LegacyOrderItemLicense.builder()
                                        .id("5bb49b91c939fc45e4e5cdbe")
                                        .uuid("d5f672d0-60f9-6940-fe3a-ff3f98ab70a8")
                                        .dateCreated(Date.from(Instant.parse("2018-10-03T10:36:01.726Z")))
                                        .dateUpdated(Date.from(Instant.parse("2018-10-03T10:36:01.726Z")))
                                        .code("10YR_MR")
                                        .description("Term 10 year Multi Region")
                                        .build()
                        )
                        .price(new BigDecimal("560.00"))
                        .transcriptsRequired(true)
                        .status("OPEN")
                        .build()
        ));
    }
}
