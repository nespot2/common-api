package com.nespot2.commonapi.profile.repository;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/02/16
 **/
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findFirstByMember(Member member);
}
