package com.nespot2.commonapi.account.service.impl;

import com.nespot2.commonapi.account.domain.AccountCategoryRoot;
import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.repository.AccountCategoryRootRepository;
import com.nespot2.commonapi.account.service.AccountCategoryRootService;
import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 * account_category_root service
 **/
@Service
@RequiredArgsConstructor
public class AccountCategoryRootServiceImpl implements AccountCategoryRootService {

    private final AccountCategoryRootRepository accountCategoryRootRepository;


    /**
     * category root를 등록합니다.
     *
     * @param accountCategoryRootDto - category root dto
     * @return
     */
    @Override
    @Transactional
    public ApiResult createAccountCategoryRoot(AccountCategoryRootDto accountCategoryRootDto) {
        accountCategoryRootRepository.save(
                AccountCategoryRoot.builder()
                        .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                        .name(accountCategoryRootDto.getName())
                        .enabled(YesNo.YES)
                        .type(accountCategoryRootDto.getType())
                        .build()
        );
        return ApiResult.ok();
    }
}
