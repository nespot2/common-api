package com.nespot2.commonapi.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.security.account.AccountContext;
import com.nespot2.commonapi.security.dto.TokenDto;
import com.nespot2.commonapi.security.jwt.JwtFactory;
import com.nespot2.commonapi.security.token.PostAuthenticationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/05
 * 로그인 authentication success handler
 **/
@Component
@RequiredArgsConstructor
public class AjaxLoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtFactory jwtFactory;

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        final AccountContext accountContext = ((PostAuthenticationToken) authentication).getAccountContext();

        final String token = jwtFactory.generateToken(accountContext);
        final String refreshToken = jwtFactory.generateRefreshToken(accountContext);

        //TODO refreshToken, generate token log 저장

        final TokenDto tokenDto = TokenDto.builder()
                .token(token)
                .refreshToken(refreshToken)
                .build();
        final ApiResult<TokenDto> apiResult = ApiResult.ok(tokenDto);

        final String tokeDtoStr = objectMapper.writeValueAsString(apiResult);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());

        response.getWriter()
                .write(tokeDtoStr);

    }
}
