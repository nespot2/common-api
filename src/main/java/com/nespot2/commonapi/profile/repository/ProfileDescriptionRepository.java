package com.nespot2.commonapi.profile.repository;

import com.nespot2.commonapi.profile.domain.ProfileDescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/04
 **/
public interface ProfileDescriptionRepository extends JpaRepository<ProfileDescription, Long> {
}
