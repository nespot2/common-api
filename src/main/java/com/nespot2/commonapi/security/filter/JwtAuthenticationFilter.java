package com.nespot2.commonapi.security.filter;

import com.nespot2.commonapi.security.handler.JwtAuthenticationFailureHandler;
import com.nespot2.commonapi.security.jwt.HeaderTokenExtractor;
import com.nespot2.commonapi.security.token.JwtPreAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private HeaderTokenExtractor headerTokenExtractor;

    private JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;

    protected JwtAuthenticationFilter(RequestMatcher matcher) {
        super(matcher);
    }

    public JwtAuthenticationFilter(RequestMatcher matcher, HeaderTokenExtractor headerTokenExtractor, JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler) {
        super(matcher);
        this.headerTokenExtractor = headerTokenExtractor;
        this.jwtAuthenticationFailureHandler = jwtAuthenticationFailureHandler;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        final SecurityContext context = SecurityContextHolder.createEmptyContext();

        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);

        chain.doFilter(request, response);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        final String header = request.getHeader("Authorization");
        final String token = headerTokenExtractor.extract(header);

        final JwtPreAuthenticationToken jwtPreAuthenticationToken = new JwtPreAuthenticationToken(token);

        return super.getAuthenticationManager().authenticate(jwtPreAuthenticationToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        jwtAuthenticationFailureHandler.onAuthenticationFailure(request, response, failed);
    }
}
