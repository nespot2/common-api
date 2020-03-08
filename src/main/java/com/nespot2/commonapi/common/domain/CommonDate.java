package com.nespot2.commonapi.common.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @versio 0.0.1
 * @since 2020/03/04
 **/
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonDate {

    @Column(nullable = false)
    private OffsetDateTime modifiedAt;

    @Column(nullable = false)
    private OffsetDateTime createdAt;

    public CommonDate(OffsetDateTime modifiedAt, OffsetDateTime createdAt) {
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }

    public void updateModifiedAt() {
        this.modifiedAt = OffsetDateTime.now();
    }
}
