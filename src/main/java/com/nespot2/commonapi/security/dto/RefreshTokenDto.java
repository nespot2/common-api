package com.nespot2.commonapi.security.dto;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class RefreshTokenDto implements Serializable {
    private String refreshToken;
}
