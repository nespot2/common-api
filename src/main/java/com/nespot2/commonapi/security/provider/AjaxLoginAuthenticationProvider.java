package com.nespot2.commonapi.security.provider;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.dto.LoginDto;
import com.nespot2.commonapi.member.service.MemberService;
import com.nespot2.commonapi.security.account.AccountContext;
import com.nespot2.commonapi.security.token.PostAuthenticationToken;
import com.nespot2.commonapi.security.token.PreAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/04
 **/
@Component
@RequiredArgsConstructor
public class AjaxLoginAuthenticationProvider implements AuthenticationProvider {

    private final MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) {
        final PreAuthenticationToken token = (PreAuthenticationToken) authentication;

        final LoginDto loginDto = LoginDto.builder()
                .email((String) token.getPrincipal())
                .password((String) token.getCredentials())
                .build();

        final Member member = memberService.login(loginDto);

        final AccountContext accountContext = new AccountContext(member.getEmail(), member.getPassword(), "ROLE_" + member.getRole().name());

        return PostAuthenticationToken.fromAccountContext(accountContext);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
