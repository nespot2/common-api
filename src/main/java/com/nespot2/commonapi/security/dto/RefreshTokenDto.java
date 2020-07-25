package com.nespot2.commonapi.security.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class RefreshTokenDto implements Serializable {
    private String refreshToken;
}
