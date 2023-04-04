package com.game.gameon.member.repository;

import com.game.gameon.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
