package com.game.gameon.game.entity;

import com.game.gameon.common.entity.BaseTimeEntity;
import com.game.gameon.member.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "apply_for_recruit_member")
@Getter
@NoArgsConstructor
public class ApplyForRecruitMemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long seq;

    @Column(nullable = true)
    private Boolean invitedYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruit_member_seq")
    private RecruitMemberEntity recruitMember;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicant_seq")
    private MemberEntity applicant;
}
