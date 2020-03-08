package com.nespot2.commonapi.profile.domain;

import com.nespot2.commonapi.common.domain.CommonDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/04
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProfileLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Embedded
    private CommonDate commonDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfileLogType logType;

    private long memberId;

    @Builder
    public ProfileLog(Profile profile, CommonDate commonDate, ProfileLogType logType, long memberId) {
        this.profile = profile;
        this.commonDate = commonDate;
        this.logType = logType;
        this.memberId = memberId;
    }
}
