package com.nespot2.commonapi.security.jwt;


import com.nespot2.commonapi.security.account.AccountContext;

public interface JwtDecode {
    AccountContext decodeToken(String token);
    AccountContext decodeRefreshToken(String token);
}
