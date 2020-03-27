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
 * 가계부 상세
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountBookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int amount;

    @Embedded
    private CommonDate commonDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_category_id")
    private AccountCategory accountCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_book_id")
    private AccountBook accountBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_payment_method_id")
    private AccountPaymentMethod accountPaymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_place_id")
    private AccountPlace accountPlace;

    @Builder
    public AccountBookDetail(String name, int amount, CommonDate commonDate, AccountCategory accountCategory, AccountBook accountBook, AccountPaymentMethod accountPaymentMethod, AccountPlace accountPlace) {
        this.name = name;
        this.amount = amount;
        this.commonDate = commonDate;
        this.accountCategory = accountCategory;
        this.accountBook = accountBook;
        this.accountPaymentMethod = accountPaymentMethod;
        this.accountPlace = accountPlace;
    }
}
