package com.nespot2.commonapi.member.domain.dto;

import com.nespot2.commonapi.common.domain.YesNo;
import com.nespot2.commonapi.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 * 회원 조회 dto
 **/
@Getter
@ToString
public class MemberDto {

    private long id;

    private String name;

    private String email;

    private MemberRole memberRole;

    private OffsetDateTime modifiedAt;

    private OffsetDateTime createdAt;

    private OffsetDateTime lastVisitAt;

    private OffsetDateTime deletedAt;

    private YesNo deleted;

    private String password;

    @Builder
    public MemberDto(long id, String name, String email, MemberRole memberRole, OffsetDateTime modifiedAt, OffsetDateTime createdAt, OffsetDateTime lastVisitAt, OffsetDateTime deletedAt, YesNo deleted, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.memberRole = memberRole;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.lastVisitAt = lastVisitAt;
        this.deletedAt = deletedAt;
        this.deleted = deleted;
        this.password = password;
    }
}
