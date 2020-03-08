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
public class ProfileDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Embedded
    private CommonDate commonDate;

    @Builder
    public ProfileDescription(String description, Profile profile, CommonDate commonDate) {
        this.description = description;
        this.profile = profile;
        this.commonDate = commonDate;
    }
}
