package com.nespot2.commonapi.account.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/26
 * 가계부 카테고리 그룹
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountCategoryGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountCategoryGroupType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncomeType incomeType;

    @Embedded
    private CommonDate commonDate;

    @Enumerated
    @Column(nullable = false)
    private YesNo enabled;

    @Builder
    public AccountCategoryGroup(String name, AccountCategoryGroupType type, IncomeType incomeType, CommonDate commonDate, YesNo enabled) {
        this.name = name;
        this.type = type;
        this.incomeType = incomeType;
        this.commonDate = commonDate;
        this.enabled = enabled;
    }
}
