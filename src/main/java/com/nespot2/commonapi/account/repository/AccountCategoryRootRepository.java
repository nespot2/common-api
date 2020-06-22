package com.nespot2.commonapi.account.repository;

import com.nespot2.commonapi.account.domain.AccountCategoryRoot;
import com.nespot2.commonapi.common.domain.YesNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/18
 **/
public interface AccountCategoryRootRepository extends JpaRepository<AccountCategoryRoot, Long> {
    List<AccountCategoryRoot> findAllByAndEnabled(YesNo enabled);
}
