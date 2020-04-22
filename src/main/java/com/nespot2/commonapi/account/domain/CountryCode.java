package com.nespot2.commonapi.account.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/18
 **/
@Getter
public enum CountryCode {
    KOR("대한민국"),
    JPN("일본"),
    USA("미국");

    private String value;

    CountryCode(String value) {
        this.value = value;
    }
}
