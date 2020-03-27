package com.nespot2.commonapi.account.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/26
 * 가계부
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private CommonDate commonDate;

    private OffsetDateTime deletedAt;

    @Column(nullable = false)
    @Enumerated
    private YesNo deleted;

    @Column(nullable = false)
    @Enumerated
    private YesNo represent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public AccountBook(String name, CommonDate commonDate, OffsetDateTime deletedAt, YesNo deleted, YesNo represent, Member member) {
        this.name = name;
        this.commonDate = commonDate;
        this.deletedAt = deletedAt;
        this.deleted = deleted;
        this.represent = represent;
        this.member = member;
    }
}
