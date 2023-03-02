package com.pragma.powerup.infrastructure.exceptionhandler;

import com.pragma.powerup.domain.exception.NumberPhoneFormatException;
import com.pragma.powerup.infrastructure.exception.CodeIdNotFoundException;
import com.pragma.powerup.infrastructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {

    private static final String MESSAGE = "message";

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(NumberPhoneFormatException.class)
    public ResponseEntity<Map<String, String>> handleNumberFormatException(
            NumberPhoneFormatException ignoredNumberPhoneFormatException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NUMBER_PHONE_FORMAT.getMessage()
                        + " : " +ignoredNumberPhoneFormatException.getMessage()));
    }

    @ExceptionHandler(CodeIdNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCodeIdNotFoundException(
            CodeIdNotFoundException codeIdNotFoundException ){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NUMBER_PHONE_FORMAT.getMessage()
                        + " : " +codeIdNotFoundException.getMessage()));
    }
    
}