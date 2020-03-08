package com.nespot2.commonapi.member.domain;

import lombok.Getter;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/04
 **/
@Getter
public enum MemberRole {

    USER,
    MANAGER,
    MASTER;

    public boolean isUser() {
        return this == USER;
    }

    public boolean isManager() {
        return this == MANAGER;
    }

    public boolean isMaster() {
        return this == MASTER;
    }
}
