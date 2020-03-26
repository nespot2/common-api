package com.nespot2.commonapi.account.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/26
 * 가계부 지출/수입 장소
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccountPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String basicAddress;

    @Column(nullable = false)
    private String detailAddress;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CountryCode countryCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String zoneCode;

    @Builder
    public AccountPlace(String basicAddress, String detailAddress, String name, CountryCode countryCode, String zoneCode) {
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
        this.name = name;
        this.countryCode = countryCode;
        this.zoneCode = zoneCode;
    }
}
