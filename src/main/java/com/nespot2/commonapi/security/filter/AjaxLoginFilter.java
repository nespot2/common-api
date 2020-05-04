package com.nespot2.commonapi.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nespot2.commonapi.member.domain.dto.LoginDto;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationFailureHandler;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationSuccessHandler;
import com.nespot2.commonapi.security.token.PreAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/05
 * 로그인 filter
 **/
public class AjaxLoginFilter extends AbstractAuthenticationProcessingFilter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;

    public AjaxLoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    public AjaxLoginFilter(String defaultFilterProcessesUrl, AjaxLoginAuthenticationSuccessHandler authenticationSuccessHandler, AjaxLoginAuthenticationFailureHandler authenticationFailureHandler) {
        this(defaultFilterProcessesUrl);
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }

        final var loginDto = new ObjectMapper().readValue(request.getReader(), LoginDto.class);


        final PreAuthenticationToken preToken = new PreAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        final AuthenticationManager authenticationManager = super.getAuthenticationManager();

        return authenticationManager.authenticate(preToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        authenticationSuccessHandler.onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        authenticationFailureHandler.onAuthenticationFailure(request, response, failed);
    }
}
