package com.nespot2.commonapi.account.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.*;

import javax.persistence.*;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/04
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountCategoryRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Column(nullable = false)
    private CommonDate commonDate;

    @Column(nullable = false)
    @Enumerated
    private YesNo enabled;

    @Builder
    public AccountCategoryRoot(String name, PaymentType type, CommonDate commonDate, YesNo enabled) {
        this.name = name;
        this.type = type;
        this.commonDate = commonDate;
        this.enabled = enabled;
    }
}
