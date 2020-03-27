package com.nespot2.commonapi.profile.exception;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/09
 **/
public class NotFoundProfileException extends RuntimeException {
    public NotFoundProfileException(String message) {
        super(message);
    }
}
