package com.game.gameon.common;

import lombok.Getter;

@Getter
public class GameonException extends RuntimeException{
    private final ErrorCode errorCode;

    public GameonException(ErrorCode errorCode,String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
