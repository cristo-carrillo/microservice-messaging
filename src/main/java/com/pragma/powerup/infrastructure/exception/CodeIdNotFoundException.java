package com.pragma.powerup.infrastructure.exception;

public class CodeIdNotFoundException extends RuntimeException{
    public CodeIdNotFoundException(String msg) {
        super(msg);
    }
}
