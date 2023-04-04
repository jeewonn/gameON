package com.game.gameon.member.dto;

import lombok.Getter;

@Getter
public class JoinRequestBody {
    private String email;
    private String password;
    private String nickname;
}
