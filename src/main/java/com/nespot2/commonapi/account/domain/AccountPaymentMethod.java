package com.nespot2.commonapi.account.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/26
 * 가계부 지출/수입 방법(현금,체크카드,신용카드, 신한은행 등등)
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountPaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountPaymentMethodType type;

    @Column(nullable = false)
    private String name;

    @Embedded
    private CommonDate commonDate;

    @Builder
    public AccountPaymentMethod(AccountPaymentMethodType type, String name, CommonDate commonDate) {
        this.type = type;
        this.name = name;
        this.commonDate = commonDate;
    }
}
