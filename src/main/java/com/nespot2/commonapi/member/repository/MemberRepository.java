package com.nespot2.commonapi.member.repository;

import com.nespot2.commonapi.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/04
 **/
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findFirstByEmail(String email);
    Optional<Member> findFirstByCellPhoneNumber(String cellPhoneNumber);
}
