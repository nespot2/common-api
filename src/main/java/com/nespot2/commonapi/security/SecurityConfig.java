package com.nespot2.commonapi.security;

import com.nespot2.commonapi.security.filter.AjaxLoginFilter;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationFailureHandler;
import com.nespot2.commonapi.security.handler.AjaxLoginAuthenticationSuccessHandler;
import com.nespot2.commonapi.security.provider.AjaxLoginAuthenticationProvider;
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

    private AjaxLoginFilter ajaxLoginFilter() throws Exception {
        final var ajaxLoginFilter = new AjaxLoginFilter("/lsf-login", ajaxLoginAuthenticationSuccessHandler, ajaxLoginAuthenticationFailureHandler);
        ajaxLoginFilter.setAuthenticationManager(super.authenticationManager());
        return ajaxLoginFilter;
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
                .mvcMatchers("/health");

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
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(ajaxLoginAuthenticationProvider);
    }
}
