package com.nespot2.commonapi.security.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenDto {
    private String token;
    private String refreshToken;

    @Builder
    public TokenDto(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }
}
