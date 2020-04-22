package com.nespot2.commonapi.account.repository;

import com.nespot2.commonapi.account.domain.AccountCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/19
 **/
public interface AccountCategoryRepository extends JpaRepository<AccountCategory, Long> {
}
