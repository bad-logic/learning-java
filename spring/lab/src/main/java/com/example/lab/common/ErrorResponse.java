package com.example.lab.common;

public class ErrorResponse<T> {
    private final String message;
    private final T errors;

    public ErrorResponse(String message, T errors) {
        this.message = message;
        this.errors = errors;
    }

    public T getErrors() {
        return errors;
    }

    public String getMessage() {
        return message;
    }
}
