package com.nespot2.commonapi.account.service.impl;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.service.AccountCategoryRootService;
import com.nespot2.commonapi.common.api.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 **/
@Service
@RequiredArgsConstructor
public class AccountCategoryRootServiceImpl implements AccountCategoryRootService {
    @Override
    @Transactional
    public ApiResult createAccountCategoryRoot(AccountCategoryRootDto accountCategoryRootDto) {
        return null;
    }
}
