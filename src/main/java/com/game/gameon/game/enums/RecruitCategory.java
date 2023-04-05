package com.game.gameon.game.enums;

import lombok.Getter;

@Getter
public enum RecruitCategory {

    NOW_IN_PROGRESS("현재","게임 진행중"),
    NOW_GO_WITH_EVERYONE("현재", "다 모이면 바로 출발"),
    RESERVE_PLAN_TO_GO("예약", "출발 예정"),
    RESERVE_GO_WITH_EVERYONE("예약", "다 안모이면 안가요"),
    RESERVE_GO_WITHOUT_EVERYONE("예약", "다 안모여도 출발");

    private String status;
    private String detailStatus;

    RecruitCategory(String status, String detailStatus) {
        this.status = status;
        this.detailStatus = detailStatus;
    }
}
