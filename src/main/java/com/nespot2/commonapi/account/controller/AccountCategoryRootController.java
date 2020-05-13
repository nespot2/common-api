package com.nespot2.commonapi.account.controller;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.service.AccountCategoryRootService;
import com.nespot2.commonapi.common.api.ApiResult;
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
 * @since 2020/05/13
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountCategoryRootController {

    private final AccountCategoryRootService accountCategoryRootService;

    /**
     * account category root 생성
     * @param accountCategoryRootDto
     * @return
     */
    @PostMapping
    public ResponseEntity<ApiResult> create(@Valid @RequestBody AccountCategoryRootDto accountCategoryRootDto) {
        return accountCategoryRootService
                .createAccountCategoryRoot(accountCategoryRootDto)
                .createResponseEntity();
    }
}
