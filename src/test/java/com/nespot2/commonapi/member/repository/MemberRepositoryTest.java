package com.nespot2.commonapi.member.repository;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/04
 * member repository test
 **/
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {

        final Member member = Member.builder()
                .deletedAt(OffsetDateTime.now())
                .email("nespot2@gmail.com")
                .password(passwordEncoder.encode("hello1234!"))
                .deleted(YesNo.NO)
                .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                .name("이재혁")
                .role(MemberRole.MASTER)
                .cellPhoneNumber("01000000000")
                .build();

        memberRepository.save(member);

        final List<Member> all = memberRepository.findAll();

        assertThat(all.size()).isEqualTo(1);

    }

    @Test
    public void test2(){
        final Optional<Member> email = memberRepository.findFirstByEmail("nespot2@gmail.com");
        assertThat(email.isPresent()).isTrue();
    }

    @Test
    public void test3(){
        final Optional<Member> member = memberRepository.findFirstByEmail("nespot2@gmail.com");

        assertThat(member.isPresent()).isTrue();

        final String password = member.get().getPassword();

        assertThat(passwordEncoder.matches("hello1234!",password)).isTrue();
    }
}