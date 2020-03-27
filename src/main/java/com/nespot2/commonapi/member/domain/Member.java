package com.nespot2.commonapi.member.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/04
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Embedded
    private CommonDate commonDate;

    @Column(nullable = false)
    private OffsetDateTime lastVisitAt;

    @Column(nullable = false)
    private OffsetDateTime deletedAt;

    @Enumerated
    private YesNo deleted;

    @Builder
    public Member(String name, String email, String password, MemberRole role, CommonDate commonDate, OffsetDateTime lastVisitAt, OffsetDateTime deletedAt, YesNo deleted) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.commonDate = commonDate;
        this.lastVisitAt = lastVisitAt;
        this.deletedAt = deletedAt;
        this.deleted = deleted;
    }
}
