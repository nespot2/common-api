package com.nespot2.commonapi.common.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/08
 **/
@NoArgsConstructor
@Getter
public class ApiResult<T> {

    @JsonProperty("c")
    private Code code;

    @JsonProperty("d")
    private T data;

    @JsonProperty("m")
    private String message;

    @JsonProperty("t")
    private OffsetDateTime timestamp;

    @Builder
    public ApiResult(Code code, T data, String message, OffsetDateTime timestamp) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.timestamp = timestamp;
    }

    public static <T> ApiResult<T> ok(T data) {
        return ApiResult
                .<T>builder()
                .code(Code.SUCCESS)
                .message(Code.SUCCESS.getMessage())
                .data(data)
                .timestamp(OffsetDateTime.now())
                .build();
    }

    public static ApiResult fail(Code code) {
        return ApiResult.builder()
                .code(code)
                .message(code.getMessage())
                .timestamp(OffsetDateTime.now())
                .build();
    }

    public static ApiResult fail(Code code, String message) {
        return ApiResult.builder()
                .code(code)
                .message(message)
                .timestamp(OffsetDateTime.now())
                .build();
    }

    public ResponseEntity createResponseEntity() {
        return ResponseEntity
                .status(code.getStatus())
                .body(this);
    }
}
