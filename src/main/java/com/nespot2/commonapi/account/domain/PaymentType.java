package com.nespot2.commonapi.account.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/18
 * 가계부 최상위 카테고리
 **/
@Getter
public enum PaymentType {

    INCOME("수입"),
    EXPENSE("지출");

    private String value;

    PaymentType(String value) {
        this.value = value;
    }

    public boolean isIncome() {
        return this == INCOME;
    }

    public boolean isExpense() {
        return this == EXPENSE;
    }

}
