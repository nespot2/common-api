package com.nespot2.commonapi.member.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/11
 * 멤버 refresh token 정보
 * enable / unable
 **/
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRefreshToken {

    @Id
    private long id;

    @Column(nullable = false)
    private String refreshToken;

    @Embedded
    private CommonDate commonDate;

    @Column(nullable = false)
    private OffsetDateTime expiredAt;


    @Column(nullable = false)
    @Enumerated
    private YesNo enabled;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Member member;

    @Builder
    public MemberRefreshToken(String refreshToken, CommonDate commonDate, OffsetDateTime expiredAt, YesNo enabled, Member member) {
        this.refreshToken = refreshToken;
        this.commonDate = commonDate;
        this.expiredAt = expiredAt;
        this.enabled = enabled;
        this.member = member;
    }

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        this.commonDate.updateModifiedAt();
        this.enabled = YesNo.YES;
    }

    public void unable() {
        this.enabled = YesNo.NO;
        this.commonDate.updateModifiedAt();
    }
}
