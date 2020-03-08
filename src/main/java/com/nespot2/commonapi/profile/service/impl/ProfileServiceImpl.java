package com.nespot2.commonapi.profile.service.impl;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.repository.MemberRepository;
import com.nespot2.commonapi.profile.domain.Profile;
import com.nespot2.commonapi.profile.domain.dto.ProfileDto;
import com.nespot2.commonapi.profile.repository.ProfileRepository;
import com.nespot2.commonapi.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/08
 **/
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public ProfileDto getProfile(long memberId) {

        final Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException(""));
        final Profile profile = profileRepository.findFirstByMember(member)
                .orElseThrow(() -> new RuntimeException(""));

        return ProfileDto
                .builder()
                .email(member.getEmail())
                .description(profile.getProfileDescription().getDescription())
                .memberName(member.getName())
                .profileName(profile.getName())
                .modifiedAt(profile.getCommonDate().getModifiedAt())
                .build();

    }
}
