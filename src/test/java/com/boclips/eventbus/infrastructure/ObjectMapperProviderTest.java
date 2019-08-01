package com.boclips.eventbus.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ObjectMapperProviderTest {

    @Test
    public void enumValuesAreWrittenAsStrings() throws JsonProcessingException {
        AnEvent event = new AnEvent();
        event.setEnumField(AnEnum.A_VALUE);

        String json = ObjectMapperProvider.get().writeValueAsString(event);

        assertThat(json).contains("\"A_VALUE\"");
    }

    enum AnEnum {
        A_VALUE
    }

    static class AnEvent {

        private AnEnum enumField;

        public AnEnum getEnumField() {
            return enumField;
        }

        public void setEnumField(AnEnum enumField) {
            this.enumField = enumField;
        }
    }
}
