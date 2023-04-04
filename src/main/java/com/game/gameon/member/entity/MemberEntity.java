package com.game.gameon.member.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Builder
    public MemberEntity(String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

}
