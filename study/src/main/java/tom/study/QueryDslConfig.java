package tom.study;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class QueryDslConfig {
    private static JPAQueryFactory jpaQueryFactory;
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        log.info("Config queryFactory: {}", jpaQueryFactory);
        return new JPAQueryFactory(entityManager);
    }
}
