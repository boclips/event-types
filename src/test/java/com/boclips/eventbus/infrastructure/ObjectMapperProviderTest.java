package com.boclips.eventbus.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectMapperProviderTest {

    private AnEvent event = new AnEvent();

    private ObjectMapper objectMapper = ObjectMapperProvider.get();

    @Test
    public void enumValuesAreWrittenAsStrings() throws JsonProcessingException {
        event.setEnumField(AnEnum.A_VALUE);

        String json = objectMapper.writeValueAsString(event);

        assertThat(json).contains("\"A_VALUE\"");
    }

    @Test
    public void dateValuesAreWrittenAsArrays() throws JsonProcessingException {
        event.setDateField(LocalDate.ofYearDay(2020, 12));

        String json = objectMapper.writeValueAsString(event);

        assertThat(json).contains("\"2020-01-12\"");
    }

    @Test
    public void dateValuesCanBeRestored() throws JsonProcessingException {
        event.setDateField(LocalDate.ofYearDay(2021, 22));

        String json = objectMapper.writeValueAsString(event);
        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent.dateField).isEqualTo("2021-01-22");
    }

    @Test
    public void datetimeValuesAreWrittenStrings() throws JsonProcessingException {
        event.setDateTimeField(ZonedDateTime.parse("2019-12-07T13:12:11Z"));

        String json = objectMapper.writeValueAsString(event);

        assertThat(json).contains("2019-12-07T13:12:11Z");
    }

    @Test
    public void datetimeValuesCanBeRestored() throws JsonProcessingException {
        event.setDateTimeField(ZonedDateTime.parse("2019-11-07T13:12:11Z"));

        String json = objectMapper.writeValueAsString(event);
        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent.dateTimeField).isEqualTo("2019-11-07T13:12:11Z");
    }

    @Test
    public void javaUtilDateSerizlisedWithVanillaObjectMapperCanBeDeserialised() throws JsonProcessingException {
        Date date = new Date();
        event.setJavaUtilDateField(date);

        String json = new ObjectMapper().writeValueAsString(event);
        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent.javaUtilDateField).isEqualTo(date);
    }

    @Test
    public void deserialisationDoesNotFailOnUnknownProperties() throws JsonProcessingException {
        String json = "{\"unknownProperty\": 0}";

        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent).isNotNull();
    }

    @Test
    public void bigDecimalValuesAreSentAsStrings() throws JsonProcessingException {
        event.setBigDecimalField(new BigDecimal("1.5"));

        String json = objectMapper.writeValueAsString(event);

        assertThat(json).contains("\"bigDecimalField\":\"1.5\"");
    }

    @Test
    public void bigDecimalValuesCanBeRestored() throws JsonProcessingException {
        event.setBigDecimalField(new BigDecimal("1.50"));

        String json = objectMapper.writeValueAsString(event);
        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent.bigDecimalField).isEqualTo("1.50");
    }

    @Test
    public void periodValuesAreWrittenAsStrings() throws JsonProcessingException {
        event.setPeriodField(Period.ofMonths(5));

        String json = objectMapper.writeValueAsString(event);

        assertThat(json).contains("\"P5M\"");
    }

    @Test
    public void periodValuesCanBeRestored() throws JsonProcessingException {
        event.setPeriodField(Period.ofMonths(5));

        String json = objectMapper.writeValueAsString(event);
        AnEvent restoredEvent = objectMapper.readValue(json, AnEvent.class);

        assertThat(restoredEvent.periodField).isEqualTo(Period.ofMonths(5));
    }

    enum AnEnum {
        A_VALUE
    }

    static class AnEvent {

        private AnEnum enumField;

        private LocalDate dateField;

        private ZonedDateTime dateTimeField;

        private Date javaUtilDateField;

        private BigDecimal bigDecimalField;

        private Period periodField;

        public AnEnum getEnumField() {
            return enumField;
        }

        public void setEnumField(AnEnum enumField) {
            this.enumField = enumField;
        }

        public LocalDate getDateField() {
            return dateField;
        }

        public void setDateField(LocalDate dateField) {
            this.dateField = dateField;
        }

        public ZonedDateTime getDateTimeField() {
            return dateTimeField;
        }

        public void setDateTimeField(ZonedDateTime dateTimeField) {
            this.dateTimeField = dateTimeField;
        }

        public BigDecimal getBigDecimalField() {
            return bigDecimalField;
        }

        public void setBigDecimalField(BigDecimal bigDecimalField) {
            this.bigDecimalField = bigDecimalField;
        }

        public Date getJavaUtilDateField() {
            return javaUtilDateField;
        }

        public void setJavaUtilDateField(Date javaUtilDateField) {
            this.javaUtilDateField = javaUtilDateField;
        }

        public Period getPeriodField() {
            return periodField;
        }

        public void setPeriodField(Period periodField) {
            this.periodField = periodField;
        }
    }
}
