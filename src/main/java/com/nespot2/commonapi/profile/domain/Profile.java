package com.nespot2.commonapi.profile.domain;

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
 * @versio 0.0.1
 * @since 2020/02/16
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private ProfileDescription profileDescription;

    @Embedded
    private CommonDate commonDate;

    @Enumerated
    private YesNo represent;

    private OffsetDateTime deleteAt;

    @Enumerated
    private YesNo deleted;

    @Builder
    public Profile(String name, Member member, ProfileDescription profileDescription, CommonDate commonDate, YesNo represent, OffsetDateTime deleteAt, YesNo deleted) {
        this.name = name;
        this.member = member;
        this.profileDescription = profileDescription;
        this.commonDate = commonDate;
        this.represent = represent;
        this.deleteAt = deleteAt;
        this.deleted = deleted;
    }
}
