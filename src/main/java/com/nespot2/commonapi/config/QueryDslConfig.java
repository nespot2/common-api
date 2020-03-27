package com.nespot2.commonapi.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author nespot2
 * @version 0.0.1
 * @since 2020/03/08
 **/
@Configuration
public class QueryDslConfig {

    @PersistenceContext
    private EntityManager entityManager;

    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
