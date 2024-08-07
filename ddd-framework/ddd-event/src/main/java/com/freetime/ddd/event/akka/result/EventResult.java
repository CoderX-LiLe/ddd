package com.freetime.ddd.event.akka.result;

import com.freetime.ddd.event.akka.enums.ErrCodeEnums;
import lombok.Data;

@Data
public class EventResult {

    private ErrCodeEnums code;

    private String message;

    public EventResult(Builder builder) {
        setCode(builder.codeEnums);
        setMessage(builder.message);
    }


    public static final class Builder{
        private ErrCodeEnums codeEnums;
        private String message;

        public Builder() {
        }

        public Builder code(ErrCodeEnums val) {
            codeEnums = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public EventResult build() {
            return new EventResult(this);
        }
    }

}
