package com.nespot2.commonapi.member.domain.dto;

import com.nespot2.commonapi.utils.customannotation.ValidPassword;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 * 회원 등록 dto
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRegisterDto {

    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 9, max = 12)
    private String cellPhoneNumber;


}
