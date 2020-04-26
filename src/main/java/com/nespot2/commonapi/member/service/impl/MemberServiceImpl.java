package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.common.advice.Nespot2BusinessException;
import com.nespot2.commonapi.common.api.Code;
import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.MemberRole;
import com.nespot2.commonapi.member.domain.dto.LoginDto;
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
     * 회원 정보 조회
     *
     * @param memberId - 회원 아이디
     * @return MemberDto
     * @throws - Nespot2BusinessException
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
     *
     * @param memberRegisterDto - 회원 정보
     * @throws - Nespot2BusinessException
     */
    @Override
    @Transactional
    public void createMember(MemberRegisterDto memberRegisterDto) {

        final String email = memberRegisterDto.getEmail();
        final String cellPhoneNumber = memberRegisterDto.getCellPhoneNumber();

        if (memberRepository.findFirstByEmail(email).isPresent()) {
            throw new Nespot2BusinessException(Code.DUPLICATE_EMAIL);
        }

        if (memberRepository.findFirstByCellPhoneNumber(cellPhoneNumber).isPresent()) {
            throw new Nespot2BusinessException(Code.DUPLICATE_CELL_PHONE_NUMBER);
        }


        final Member member = Member.builder()
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .email(email)
                .deleted(YesNo.NO)
                .lastVisitAt(OffsetDateTime.now())
                .name(memberRegisterDto.getName())
                .password(passwordEncoder.encode(memberRegisterDto.getPassword()))
                .role(MemberRole.USER)
                .cellPhoneNumber(cellPhoneNumber)
                .build();

        memberRepository.save(member);
    }

    /**
     * 로그인
     *
     * @param loginDto - 로그인 정보
     * @return MemberDto - 회원정보
     * @throws Nespot2BusinessException
     */
    @Override
    public MemberDto login(LoginDto loginDto) {

        final String email = loginDto.getEmail();
        final String password = loginDto.getPassword();

        final Member member = memberRepository
                .findFirstByEmail(email)
                .orElseThrow(() -> new Nespot2BusinessException(Code.EMAIL_NOT_FOUND));

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new Nespot2BusinessException(Code.PASSWORD_NOT_MATCHED);
        }

        return memberMapper.map(member);
    }

}
