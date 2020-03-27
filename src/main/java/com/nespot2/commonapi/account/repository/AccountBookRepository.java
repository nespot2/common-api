package com.nespot2.commonapi.account.repository;

import com.nespot2.commonapi.account.domain.AccountBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/26
 **/
public interface AccountBookRepository extends JpaRepository<AccountBook, Long> {
}
