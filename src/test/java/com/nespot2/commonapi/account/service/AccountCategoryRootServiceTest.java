package com.nespot2.commonapi.account.service;

import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/06/22
 **/
@SpringBootTest
class AccountCategoryRootServiceTest {

    @Autowired
    private AccountCategoryRootService accountCategoryRootService;


    @Test
    @Transactional(readOnly = true)
    public void test() {
        final List<AccountCategoryRootDto> lists = accountCategoryRootService.getAllAccountCategoryRootDto();
        assertEquals(2, lists.size());
    }
}