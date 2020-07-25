package com.nespot2.commonapi.account.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/07/25
 **/
@Getter
public enum AccountPaymentMethodType {
    BANK_TRANSFER("계좌이체"),
    CHECK_CARD("체크카드"),
    CREDIT_CARD("신용카드"),
    CASH("현금");
    private String value;

    AccountPaymentMethodType(String value) {
        this.value = value;
    }

    public boolean isBaskTransfer() {
        return this == BANK_TRANSFER;
    }

    public boolean isCreditCard() {
        return this == CREDIT_CARD;
    }

    public boolean isCheckCard() {
        return this == CHECK_CARD;
    }

    public boolean isCash() {
        return this == CASH;
    }


}
