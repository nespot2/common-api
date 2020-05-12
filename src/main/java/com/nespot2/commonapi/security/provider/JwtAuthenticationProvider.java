package com.nespot2.commonapi.security.provider;

import com.nespot2.commonapi.security.account.AccountContext;
import com.nespot2.commonapi.security.jwt.JwtDecode;
import com.nespot2.commonapi.security.token.JwtPostAuthenticationToken;
import com.nespot2.commonapi.security.token.JwtPreAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtDecode jwtDecode;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final String token = (String) authentication.getPrincipal();

        final AccountContext accountContext = jwtDecode.decodeToken(token);

        return JwtPostAuthenticationToken.fromAccountContext(accountContext);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
