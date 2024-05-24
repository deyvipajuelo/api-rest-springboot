package com.dpajuelo.apirest.web.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseMessage<T> {

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T content;


    public static <T> ResponseMessage<T> of(String message) {
        return ResponseMessage.<T>builder()
                .message(message)
                .build();
    }

    public static <T> ResponseMessage<T> of(String message, T content) {
        return ResponseMessage.<T>builder()
                .message(message)
                .content(content)
                .build();
    }
}
