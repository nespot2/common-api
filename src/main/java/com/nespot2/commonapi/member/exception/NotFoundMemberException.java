package com.nespot2.commonapi.member.exception;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/09
 **/
public class NotFoundMemberException extends RuntimeException {
    public NotFoundMemberException(String message) {
        super(message);
    }
}
