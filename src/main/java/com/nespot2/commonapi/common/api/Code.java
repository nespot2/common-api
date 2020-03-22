package com.nespot2.commonapi.common.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/08
 **/
@Getter
public enum Code {

    SUCCESS(HttpStatus.OK, "성공하였습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 에러가 발생하였습니다."),
    UNAUTHENTICATED(HttpStatus.FORBIDDEN, "잘못된 인증 정보입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "not found user"),
    NOT_FOUND_PROFILE(HttpStatus.NOT_FOUND, "not found profile");

    private HttpStatus status;

    private String message;

    Code(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
