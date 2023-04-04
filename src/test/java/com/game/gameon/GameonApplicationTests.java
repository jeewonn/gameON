package com.game.gameon;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class GameonApplicationTests {

    @Autowired
    EntityManager em;

    @Test
    void contextLoads() {

        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory query = new JPAQueryFactory(em);

        QHello qHello = QHello.hello;

        Hello result = query.selectFrom(qHello).fetchOne();

        Assertions.assertThat(result).isEqualTo(hello);
        Assertions.assertThat(result.getId()).isEqualTo(hello.getId());

    }

}
