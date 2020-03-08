package com.nespot2.commonapi.profile.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/04
 **/
@Getter
public class ProfileDto {

    private String profileName;

    private String description;

    private String memberName;

    private String email;

    private OffsetDateTime modifiedAt;

    @Builder
    public ProfileDto(String profileName, String description, String memberName, String email, OffsetDateTime modifiedAt) {
        this.profileName = profileName;
        this.description = description;
        this.memberName = memberName;
        this.email = email;
        this.modifiedAt = modifiedAt;
    }
}
