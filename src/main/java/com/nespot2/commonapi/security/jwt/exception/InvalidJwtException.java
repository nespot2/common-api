package com.nespot2.commonapi.security.jwt.exception;


import org.springframework.security.authentication.InternalAuthenticationServiceException;

public class InvalidJwtException extends InternalAuthenticationServiceException {

    public InvalidJwtException(String message) {
        super(message);
    }
}
