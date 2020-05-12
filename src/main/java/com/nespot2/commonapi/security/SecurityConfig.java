package com.nespot2.commonapi.security;

import com.nespot2.commonapi.security.filter.AjaxLoginFilter;
import com.nespot2.commonapi.security.filter.FilterSkipMatcher;
import com.nespot2.commonapi.security.filter.JwtAuthenticationFilter;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationFailureHandler;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationSuccessHandler;
import com.nespot2.commonapi.security.handler.JwtAuthenticationFailureHandler;
import com.nespot2.commonapi.security.jwt.HeaderTokenExtractor;
import com.nespot2.commonapi.security.provider.AjaxLoginAuthenticationProvider;
import com.nespot2.commonapi.security.provider.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/02/16
 **/
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AjaxLoginAuthenticationSuccessHandler ajaxLoginAuthenticationSuccessHandler;

    private final AjaxLoginAuthenticationFailureHandler ajaxLoginAuthenticationFailureHandler;

    private final AjaxLoginAuthenticationProvider ajaxLoginAuthenticationProvider;

    private final JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    private final HeaderTokenExtractor headerTokenExtractor;

    private AjaxLoginFilter ajaxLoginFilter() throws Exception {
        final var ajaxLoginFilter = new AjaxLoginFilter("/login", ajaxLoginAuthenticationSuccessHandler, ajaxLoginAuthenticationFailureHandler);
        ajaxLoginFilter.setAuthenticationManager(super.authenticationManager());
        return ajaxLoginFilter;
    }

    private JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        final List<String> pathToSkip = Arrays.asList("/login", "/refresh");

        final var processing = "/**";
        final FilterSkipMatcher filterSkipMatcher = new FilterSkipMatcher(pathToSkip, processing);
        final var jwtAuthenticationFilter = new JwtAuthenticationFilter(filterSkipMatcher, headerTokenExtractor, jwtAuthenticationFailureHandler);
        jwtAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        return jwtAuthenticationFilter;
    }

    public SecurityExpressionHandler expressionHandler() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ROOT > ROLE_LEADER > ROLE_MANAGER > ROLE_USER > ROLE_FACTORY");

        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);

        return handler;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .mvcMatchers("/health", "/docs/index.html", "/favicon.ico");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .csrf()
                .disable();

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .expressionHandler(expressionHandler());

        http.addFilterBefore(ajaxLoginFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(ajaxLoginAuthenticationProvider);
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}
