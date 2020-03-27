package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.repository.MemberRepository;
import com.nespot2.commonapi.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Optional<Member> findMember(long memberId) {
        return memberRepository.findById(memberId);
    }
}
