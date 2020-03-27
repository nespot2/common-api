package com.nespot2.commonapi.account.repository;

import com.nespot2.commonapi.account.domain.AccountCategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/27
 **/
public interface AccountCategoryGroupRepository extends JpaRepository<AccountCategoryGroup, Long> {
}
