package com.nespot2.commonapi.security.jwt;

public interface HeaderTokenExtractor {
    String extract(String header);
}
