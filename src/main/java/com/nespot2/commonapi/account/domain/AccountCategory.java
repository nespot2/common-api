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
 * @version 0.0.1
 * @since 2020/03/26
 * 가계부 카테고리
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private CommonDate commonDate;

    @Enumerated
    private YesNo enabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private AccountCategoryGroup accountCategoryGroup;

    @Builder
    public AccountCategory(String name, CommonDate commonDate, YesNo enabled, AccountCategoryGroup accountCategoryGroup) {
        this.name = name;
        this.commonDate = commonDate;
        this.enabled = enabled;
        this.accountCategoryGroup = accountCategoryGroup;
    }
}
