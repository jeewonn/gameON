package com.game.gameon.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GameonExceptionHandler {

    @ExceptionHandler(value = {GameonException.class})
    public ResponseEntity<GameonResponse<Void>> handleGameonException(GameonException exception){
        ErrorCode errorCode = exception.getErrorCode();
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(GameonResponse.ofCodeMessage(errorCode, exception.getMessage()));
    }
}
