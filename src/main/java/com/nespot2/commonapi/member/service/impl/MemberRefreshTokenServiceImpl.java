package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.MemberRefreshToken;
import com.nespot2.commonapi.member.repository.MemberRefreshTokenRepository;
import com.nespot2.commonapi.member.repository.MemberRepository;
import com.nespot2.commonapi.member.service.MemberRefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/11
 * member refresh token service
 **/
@Service
@RequiredArgsConstructor
public class MemberRefreshTokenServiceImpl implements MemberRefreshTokenService {

    private final MemberRefreshTokenRepository memberRefreshTokenRepository;

    private final MemberRepository memberRepository;

    @Value("${jwt.refresh-expired-day:14}")
    private int refreshExpiredDay;

    /**
     * refreshToken 정보 저장
     *
     * @param email        - email
     * @param refreshToken - refresh token
     */
    @Override
    @Transactional
    public void saveRefreshToken(final String email, final String refreshToken) {

        final Member member = memberRepository
                .findFirstByEmail(email)
                .orElseThrow(() -> new InternalAuthenticationServiceException("회원 정보를 찾을 수 없습니다."));

        final Optional<MemberRefreshToken> memberRefreshTokenOptional = memberRefreshTokenRepository.findById(member.getId());


        if (memberRefreshTokenOptional.isPresent()) {
            final MemberRefreshToken memberRefreshToken = memberRefreshTokenOptional.get();
            memberRefreshToken.updateRefreshToken(refreshToken);
        } else {
            final MemberRefreshToken memberRefreshToken = MemberRefreshToken.builder()
                    .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                    .enabled(YesNo.YES)
                    .expiredAt(OffsetDateTime.now().plusDays(refreshExpiredDay))
                    .refreshToken(refreshToken)
                    .member(member)
                    .build();
            memberRefreshTokenRepository.save(memberRefreshToken);
        }
    }
}
