package com.game.gameon.game.enums;

import lombok.Getter;

@Getter
public enum RecruitStatus {
    OPEN("진행중"),
    CLOSE("종료");

    private String value;

    RecruitStatus(String value) {
        this.value = value;
    }
}
