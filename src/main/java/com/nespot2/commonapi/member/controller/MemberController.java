package com.nespot2.commonapi.member.controller;

import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.member.domain.dto.MemberRegisterDto;
import com.nespot2.commonapi.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 **/
@RestController
@RequestMapping("/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원 가입 API
     *
     * @param memberRegisterDto - 회원 정보
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<ApiResult> createMember(@Valid @RequestBody MemberRegisterDto memberRegisterDto) {
        memberService.createMember(memberRegisterDto);
        return ApiResult.ok().createResponseEntity();
    }

}
