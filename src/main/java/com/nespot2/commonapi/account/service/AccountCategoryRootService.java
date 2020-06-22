package com.nespot2.commonapi.account.service;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootParamDto;

import java.util.List;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 *
 * account category root service
 **/
public interface AccountCategoryRootService {

    /**
     * category root를 등록합니다.
     *
     * @param accountCategoryRootParamDto - category root param dto
     * @return
     */
    void createAccountCategoryRoot(AccountCategoryRootParamDto accountCategoryRootParamDto);

    /**
     * account category root 모두 조회
     * @return
     */
    List<AccountCategoryRootDto> getAllAccountCategoryRootDto();
}
