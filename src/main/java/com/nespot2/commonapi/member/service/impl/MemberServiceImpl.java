package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.common.advice.Nespot2BusinessException;
import com.nespot2.commonapi.common.api.Code;
import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.MemberRole;
import com.nespot2.commonapi.member.domain.dto.MemberDto;
import com.nespot2.commonapi.member.domain.dto.MemberRegisterDto;
import com.nespot2.commonapi.member.repository.MemberRepository;
import com.nespot2.commonapi.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 * 회원 service
 **/
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    private final MemberMapper memberMapper;

    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 정보를 조회합니다.
     *
     * @param memberId - 회원 아이디
     * @return MemberDto
     */
    @Override
    public MemberDto findMember(long memberId) {
        final Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new Nespot2BusinessException(Code.NOT_FOUND_MEMBER));

        return memberMapper.map(member);
    }

    /**
     * 회원 가입
     * @param memberRegisterDto - 회원 정보
     */
    @Override
    @Transactional
    public void createMember(MemberRegisterDto memberRegisterDto) {

        final Member member = Member.builder()
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .email(memberRegisterDto.getEmail())
                .deleted(YesNo.NO)
                .lastVisitAt(OffsetDateTime.now())
                .name(memberRegisterDto.getName())
                .password(passwordEncoder.encode(memberRegisterDto.getPassword()))
                .role(MemberRole.USER)
                .cellPhoneNumber(memberRegisterDto.getCellPhoneNumber())
                .build();

        memberRepository.save(member);
    }

}
