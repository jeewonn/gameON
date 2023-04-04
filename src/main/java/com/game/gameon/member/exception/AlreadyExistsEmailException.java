package com.game.gameon.member.exception;

import com.game.gameon.common.ErrorCode;
import com.game.gameon.common.GameonException;

public class AlreadyExistsEmailException extends GameonException {

    private static final ErrorCode ERROR_CODE = ErrorCode.ALREADY_EXISTS_EMAIL;

    public AlreadyExistsEmailException() {
        super(ERROR_CODE, ERROR_CODE.getResultMessage());
    }
}
