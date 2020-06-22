package com.nespot2.commonapi.account.service.impl;

import com.nespot2.commonapi.account.domain.AccountCategoryRoot;
import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootDto;
import com.nespot2.commonapi.account.domain.dto.AccountCategoryRootParamDto;
import com.nespot2.commonapi.account.repository.AccountCategoryRootRepository;
import com.nespot2.commonapi.account.service.AccountCategoryRootService;
import com.nespot2.commonapi.common.domain.CommonDate;
import com.nespot2.commonapi.common.domain.YesNo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
     * @param accountCategoryRootParamDto - category root param dto
     * @return
     */
    @Override
    @Transactional
    public void createAccountCategoryRoot(AccountCategoryRootParamDto accountCategoryRootParamDto) {
        accountCategoryRootRepository.save(
                AccountCategoryRoot.builder()
                        .commonDate(new CommonDate(OffsetDateTime.now(), OffsetDateTime.now()))
                        .name(accountCategoryRootParamDto.getName())
                        .enabled(YesNo.YES)
                        .type(accountCategoryRootParamDto.getType())
                        .build()
        );
    }

    @Override
    public List<AccountCategoryRootDto> getAllAccountCategoryRootDto() {
        final List<AccountCategoryRoot> all = accountCategoryRootRepository.findAllByAndEnabled(YesNo.YES);

        final ArrayList<AccountCategoryRootDto> results = new ArrayList<>();

        for (AccountCategoryRoot accountCategoryRoot : all) {
            results.add(
                    AccountCategoryRootDto
                            .builder()
                            .id(accountCategoryRoot.getId())
                            .name(accountCategoryRoot.getName())
                            .type(accountCategoryRoot.getType())
                            .createdAt(accountCategoryRoot.getCommonDate().getCreatedAt())
                            .modifiedAt(accountCategoryRoot.getCommonDate().getModifiedAt())
                            .build()
            );
        }
        return results;
    }
}
