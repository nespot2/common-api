package com.nespot2.commonapi.account.controller;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.service.AccountCategoryRootService;
import com.nespot2.commonapi.common.api.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/account-root")
public class AccountCategoryRootController {

    private final AccountCategoryRootService accountCategoryRootService;

    @GetMapping
    public ResponseEntity<ApiResult<List<AccountCategoryRootDto>>> getAll() {
        return ApiResult.ok(accountCategoryRootService.getAllAccountCategoryRootDto()).createResponseEntity();
    }

}
