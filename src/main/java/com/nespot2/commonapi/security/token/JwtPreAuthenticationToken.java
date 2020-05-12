package com.nespot2.commonapi.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtPreAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public JwtPreAuthenticationToken(String token) {
        super(token, token.length());
    }
}
