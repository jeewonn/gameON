package com.game.gameon.game.entity;

import com.game.gameon.common.entity.BaseTimeEntity;
import com.game.gameon.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member_game_account")
@Getter
@NoArgsConstructor
public class MemberGameAccountEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(nullable = false, length = 255)
    private String gameId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_type_seq")
    private GameTypeEntity gameType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_seq")
    private MemberEntity member;
}
