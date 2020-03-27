package com.nespot2.commonapi.member.service;

import com.nespot2.commonapi.member.domain.Member;

import java.util.Optional;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
public interface MemberService {
    Optional<Member> findMember(long memberId);
}
