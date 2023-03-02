package com.pragma.powerup.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data found for the requested petition"),
    NUMBER_PHONE_FORMAT("The phone number format is incorrect"),
    CODE_ID_NOT_FOUND("The code is invalid for order");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}