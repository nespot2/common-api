package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/08
 **/
@SpringBootTest
public class MemberServiceImplTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void test(){

        final Optional<Member> member = memberService.findMember(2);

        assertThat(member.isPresent()).isTrue();

        assertThat(member.map(Member::getName).orElse("")).isEqualTo("이재혁");
    }

}