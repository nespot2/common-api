package com.nespot2.commonapi.common.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
@Getter
public enum Code {

    SUCCESS(HttpStatus.OK, "성공하였습니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청 입니다."),
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에서 에러가 발생하였습니다."),
    UNAUTHENTICATED(HttpStatus.FORBIDDEN, "잘못된 인증 정보입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "권한이 없습니다."),
    NOT_FOUND_MEMBER(HttpStatus.NOT_FOUND, "회원 정보를 찾을 수 없습니다."),
    NOT_FOUND_PROFILE(HttpStatus.NOT_FOUND, "프로필 정보를 찾을 수 없습니다."),

    //회원
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "이메일이 중복되었습니다."),
    DUPLICATE_CELL_PHONE_NUMBER(HttpStatus.BAD_REQUEST, "전화번호가 중복되었습니다."),
    PASSWORD_NOT_MATCHED(HttpStatus.BAD_REQUEST, "패스워드 정보가 잘못되었습니다."),
    EMAIL_NOT_FOUND(HttpStatus.BAD_REQUEST, "잘못된 이메일 정보 입니다.");

    private HttpStatus status;

    private String message;

    Code(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
