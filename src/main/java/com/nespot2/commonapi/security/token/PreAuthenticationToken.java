package com.nespot2.commonapi.security.token;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/04
 **/
public class PreAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public PreAuthenticationToken(String username, String password) {
        super(username, password);
    }
}
