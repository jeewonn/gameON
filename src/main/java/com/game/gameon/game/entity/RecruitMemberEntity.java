package com.game.gameon.game.entity;

import com.game.gameon.common.entity.BaseTimeEntity;
import com.game.gameon.game.enums.RecruitCategory;
import com.game.gameon.game.enums.RecruitStatus;
import com.game.gameon.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor
public class RecruitMemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = true, length = 500)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecruitCategory RecruitCategory;

    @Column(nullable = false)
    private int limitPeople;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_name_seq")
    private GameNameEntity gameName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_seq")
    private MemberEntity writer;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RecruitStatus RecruitStatus;

    @Column(nullable = false)
    private LocalDateTime startAt;
}
