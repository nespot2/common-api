package com.nespot2.commonapi.security.token;

import com.nespot2.commonapi.security.account.AccountContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtPostAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public JwtPostAuthenticationToken(Object context, String credentials, Collection<? extends GrantedAuthority> authorities) {
        super(context, credentials, authorities);
    }

    public static JwtPostAuthenticationToken fromAccountContext(AccountContext accountContext) {
        return new JwtPostAuthenticationToken(accountContext, accountContext.getPassword(), accountContext.getAuthorities());
    }

}
