package com.nespot2.commonapi.account.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/26
 **/
@Getter
public enum IncomeType {
    INCOME("수입"),
    SPENDING("지출");

    private String value;

    IncomeType(String value) {
        this.value = value;
    }
}
