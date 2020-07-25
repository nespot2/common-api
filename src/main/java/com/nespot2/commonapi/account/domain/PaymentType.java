package com.nespot2.commonapi.account.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/18
 * 수입/지출 타입
 **/
@Getter
public enum PaymentType {

    FIXED_INCOME("고정 수입"),
    VARIABLE_INCOME("변동 수입"),
    FIXED_EXPENDITURE("고정 지출"),
    VARIABLE_EXPENDITURE("변동 지출");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public boolean isFixedIncome() {
        return this == FIXED_INCOME;
    }

    public boolean isVariableIncome() {
        return this == VARIABLE_INCOME;
    }

    public boolean isFixedExpenditure() {
        return this == FIXED_EXPENDITURE;
    }

    public boolean isVariableExpenditure() {
        return this == VARIABLE_EXPENDITURE;
    }

}
