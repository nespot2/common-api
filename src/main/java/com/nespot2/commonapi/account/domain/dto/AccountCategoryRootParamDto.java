package com.nespot2.commonapi.account.domain.dto;

import com.nespot2.commonapi.account.domain.PaymentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountCategoryRootParamDto {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private PaymentType type;

    public AccountCategoryRootParamDto(String name, PaymentType type) {
        this.name = name;
        this.type = type;
    }
}
