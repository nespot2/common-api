package com.nespot2.commonapi.account.service;

import com.nespot2.commonapi.account.domain.PaymentType;
import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.common.api.ApiResult;
import com.nespot2.commonapi.common.api.Code;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/13
 **/
@SpringBootTest
class AccountCategoryRootServiceTest {

    @Autowired
    private AccountCategoryRootService accountCategoryRootService;

    @Test
    @Transactional
    public void test(){
        final ApiResult result1 = accountCategoryRootService.createAccountCategoryRoot(new AccountCategoryRootDto("지출", PaymentType.EXPENSE));
        final ApiResult result2 = accountCategoryRootService.createAccountCategoryRoot(new AccountCategoryRootDto("수입", PaymentType.INCOME));

        assertThat(result1.getCode()).isEqualTo(Code.SUCCESS);
        assertThat(result2.getCode()).isEqualTo(Code.SUCCESS);
    }

}