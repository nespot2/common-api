package com.nespot2.commonapi.security.jwt.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nespot2.commonapi.security.account.AccountContext;
import com.nespot2.commonapi.security.jwt.JwtFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;


@Component
public class JwtFactoryImpl implements JwtFactory {

    @Value("${jwt.signing-key:{none}}")
    private String signingKey;

    @Value("${jwt.refresh-expired-day:14}")
    private int refreshExpiredDay;

    @Value("${jwt.refresh-signing-key:{none}}")
    private String refreshSigningKey;

    @Override
    public String generateToken(AccountContext accountContext) {

        final var expiredAt = getExpiredAtWithHour(1);

        final String username = accountContext.getUsername();
        final String role = accountContext.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst().orElse("");

        return JWT.create()
                .withIssuer("laundrygo")
                .withExpiresAt(expiredAt)
                .withClaim("name", username)
                .withClaim("role", role)
                .sign(generateAlgorithm(signingKey));
    }

    @Override
    public String generateRefreshToken(AccountContext accountContext) {

        final var expiredAt = getExpiredAt(refreshExpiredDay);

        final String username = accountContext.getUsername();
        final String role = accountContext.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst().orElse("");

        return JWT.create()
                .withIssuer("laundrygo")
                .withExpiresAt(expiredAt)
                .withClaim("name", username)
                .withClaim("role", role)
                .sign(generateAlgorithm(refreshSigningKey));
    }


    private Date getExpiredAtWithHour(int hours) {
        return Date.from(LocalDateTime.now().plusHours(hours).toInstant(ZoneOffset.of("+09:00")));
    }

    private Date getExpiredAt(int day) {
        return Date.from(LocalDateTime.now().plusDays(day).toInstant(ZoneOffset.of("+09:00")));
    }

    private Algorithm generateAlgorithm(final String key) {
        return Algorithm.HMAC256(key);
    }
}
