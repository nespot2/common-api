package com.nespot2.commonapi.security.jwt.impl;

import com.nespot2.commonapi.security.jwt.HeaderTokenExtractor;
import com.nespot2.commonapi.security.jwt.exception.InvalidJwtException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

@Component
public class HeaderTokenExtractorImpl implements HeaderTokenExtractor {

    public static final String HEADER_PREFIX = "Bearer ";

    @Override
    public String extract(String header) {
        if (StringUtils.isEmpty(header) || header.length() < HEADER_PREFIX.length()) {
            throw new InvalidJwtException("올바른 토큰 정보가 아닙니다.");
        }

        return header.substring(HEADER_PREFIX.length());
    }
}
