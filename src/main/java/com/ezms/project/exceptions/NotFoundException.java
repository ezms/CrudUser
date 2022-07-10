package com.ezms.project.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {}

    public NotFoundException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage() + ": No data found :( ";
    }
}
