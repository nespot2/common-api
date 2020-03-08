package com.nespot2.commonapi.profile.service;

import com.nespot2.commonapi.profile.domain.dto.ProfileDto;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/02/16
 **/
public interface ProfileService {
    ProfileDto getProfile(long memberId);
}
