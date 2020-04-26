package com.nespot2.commonapi.member.service;

import com.nespot2.commonapi.member.domain.dto.LoginDto;
import com.nespot2.commonapi.member.domain.dto.MemberDto;
import com.nespot2.commonapi.member.domain.dto.MemberRegisterDto;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 * 회원 service
 **/
public interface MemberService {
    MemberDto findMember(long memberId);

    void createMember(MemberRegisterDto memberRegisterDto);

    MemberDto login(LoginDto loginDto);

}
