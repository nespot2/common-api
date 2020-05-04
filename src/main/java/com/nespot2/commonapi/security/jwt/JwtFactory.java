package com.nespot2.commonapi.security.jwt;


import com.nespot2.commonapi.security.account.AccountContext;

/**
 * @author nespot2
 * @since 2019-12-23
 * jwt token 생성
 */
public interface JwtFactory {
    String generateToken(AccountContext accountContext);
    String generateRefreshToken(AccountContext accountContext);
}
