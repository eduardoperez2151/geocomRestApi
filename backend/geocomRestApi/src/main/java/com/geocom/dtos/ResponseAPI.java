package com.geocom.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class ResponseAPI {

    public static final String SUCCESS_CODE = "0";
    public static final String SUCCESS_MESSAGE = "OK";

    public static final String ERROR_CODE = "1";
    public static final String ERROR_MESSAGE = "ERROR";


    private String code;
    private String message;
    private Object data;


    public static <T> ResponseAPI ok(T data) {
        return getResponseAPI(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static <T> ResponseAPI error(T data) {
        return getResponseAPI(ERROR_CODE, ERROR_MESSAGE, data);
    }

    private static <T> ResponseAPI getResponseAPI(final String code, final String message, final T data) {
        return ResponseAPI.builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

}
