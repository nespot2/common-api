package com.nespot2.commonapi.member.service.impl;

import com.nespot2.commonapi.member.domain.Member;
import com.nespot2.commonapi.member.domain.dto.MemberDto;
import org.springframework.stereotype.Service;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 **/
@Service
public class MemberMapper {
    public MemberDto map(Member member) {
        return MemberDto
                .builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .memberRole(member.getRole())
                .createdAt(member.getCommonDate().getCreatedAt())
                .deleted(member.getDeleted())
                .modifiedAt(member.getCommonDate().getModifiedAt())
                .deletedAt(member.getDeletedAt())
                .lastVisitAt(member.getLastVisitAt())
                .password(member.getPassword())
                .build();
    }
}
