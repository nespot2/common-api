package com.nespot2.commonapi.account.repository;

import com.nespot2.commonapi.account.domain.AccountBookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/04/18
 **/
public interface AccountBookDetailRepository extends JpaRepository<AccountBookDetail, Long> {
}
