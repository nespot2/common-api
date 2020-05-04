package com.nespot2.commonapi.security.jwt.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nespot2.commonapi.security.account.AccountContext;
import com.nespot2.commonapi.security.jwt.JwtDecode;
import com.nespot2.commonapi.security.jwt.exception.InvalidJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class JwtDecodeImpl implements JwtDecode {

    @Value("${jwt.signing-key:{none}}")
    private String signingKey;

    @Value("${jwt.refresh-signing-key:{none}}")
    private String refreshSigningKey;

    @Override
    public AccountContext decodeToken(String token) {
        return decodeJwt(token, signingKey);
    }

    @Override
    public AccountContext decodeRefreshToken(String token) {
        return decodeJwt(token, refreshSigningKey);
    }

    private AccountContext decodeJwt(String token, String key) {
        final DecodedJWT decodedJWT = isValidToken(token, key).orElseThrow(() -> new InvalidJwtException("유효한 토큰이 아닙니다."));
        final String name = decodedJWT.getClaim("name").asString();
        final String role = decodedJWT.getClaim("role").asString();
        return new AccountContext(name, "", role);
    }


    private Optional<DecodedJWT> isValidToken(String token, String key) {
        final var verifier = JWT.require(generateAlgorithm(key)).build();
        try {
            final var verify = verifier.verify(token);
            return Optional.ofNullable(verify);
        } catch (JWTVerificationException e) {
            throw new InvalidJwtException(e.getMessage());
        }
    }

    private Algorithm generateAlgorithm(final String key) {
        return Algorithm.HMAC256(key);
    }


}
