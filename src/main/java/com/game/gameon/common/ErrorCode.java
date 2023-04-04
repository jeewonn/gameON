package com.game.gameon.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ALREADY_EXISTS_EMAIL(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일 주소입니다."),
    ALREADY_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST, "이미 존재하는 이메일 주소입니다.");

    private final HttpStatus httpStatus;
    private final String resultMessage;

    ErrorCode(HttpStatus httpStatus, String resultMessage) {
        this.httpStatus = httpStatus;
        this.resultMessage = resultMessage;
    }
}
