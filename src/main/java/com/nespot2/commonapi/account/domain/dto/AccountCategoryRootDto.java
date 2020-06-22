package com.nespot2.commonapi.account.domain.dto;

import com.nespot2.commonapi.account.domain.PaymentType;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/06/22
 **/
@Getter
public class AccountCategoryRootDto {

    private long id;

    private String name;

    private PaymentType type;

    private OffsetDateTime createdAt;

    private OffsetDateTime modifiedAt;

    @Builder
    public AccountCategoryRootDto(long id, String name, PaymentType type, OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
