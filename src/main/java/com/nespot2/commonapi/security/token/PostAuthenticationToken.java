package com.nespot2.commonapi.security.token;

import com.nespot2.commonapi.security.account.AccountContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/04
 **/
public class PostAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public PostAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public AccountContext getAccountContext() {
        return (AccountContext) super.getPrincipal();
    }

    public static PostAuthenticationToken fromAccountContext(AccountContext accountContext) {
        return new PostAuthenticationToken(accountContext, accountContext.getPassword(), accountContext.getAuthorities());
    }
}
