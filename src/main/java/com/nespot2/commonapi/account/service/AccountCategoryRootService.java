package com.nespot2.commonapi.account.service;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.common.api.ApiResult;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 *
 * account category root service
 **/
public interface AccountCategoryRootService {
    ApiResult createAccountCategoryRoot(AccountCategoryRootDto accountCategoryRootDto);
}
