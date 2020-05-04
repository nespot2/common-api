package com.nespot2.commonapi.security.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;

public class AccountContext extends User {
    public AccountContext(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public AccountContext(String username, String password, String role) {
        this(username, password, Arrays.asList(new SimpleGrantedAuthority(role)));
    }
}
