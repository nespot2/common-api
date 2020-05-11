package com.nespot2.commonapi.member.repository;

import com.nespot2.commonapi.member.domain.MemberRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/05/12
 **/
public interface MemberRefreshTokenRepository extends JpaRepository<MemberRefreshToken, Long> {
}
