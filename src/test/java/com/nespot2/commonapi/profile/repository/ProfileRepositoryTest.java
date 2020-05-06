package com.nespot2.commonapi.profile.repository;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.repository.MemberRepository;
import com.nespot2.commonapi.profile.domain.Profile;
import com.nespot2.commonapi.profile.domain.ProfileDescription;
import com.nespot2.commonapi.profile.domain.ProfileLog;
import com.nespot2.commonapi.profile.domain.ProfileLogType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/04
 * profile repository test
 **/
@SpringBootTest
@Transactional
public class ProfileRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileDescriptionRepository profileDescriptionRepository;

    @Autowired
    private ProfileLogRepository profileLogRepository;

    @Test
    public void test() {

        final Member member = memberRepository
                .findById(2l)
                .orElseThrow(() -> new RuntimeException("I haven't found member"));


        final Profile profile = Profile.builder()
                .member(member)
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .name("개발을 사랑하는 5년차 웹 개발자")
                .build();

        final Profile saveProfile = profileRepository.save(profile);

        final ProfileDescription profileDescription = ProfileDescription.builder()
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .description("저는 IT를 사랑하는 5년차 웹 개발자입니다.")
                .profile(profile)
                .build();

        profileDescriptionRepository.save(profileDescription);

        final ProfileLog profileLog = ProfileLog.builder()
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .memberId(member.getId())
                .profile(saveProfile)
                .logType(ProfileLogType.INSERT)
                .build();

        profileLogRepository.save(profileLog);


    }


}