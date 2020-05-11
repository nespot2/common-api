package com.nespot2.commonapi.member.service;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/11
 * member refresh token service
 **/
public interface MemberRefreshTokenService {
    void saveRefreshToken(final String email, final String refreshToken);
}
