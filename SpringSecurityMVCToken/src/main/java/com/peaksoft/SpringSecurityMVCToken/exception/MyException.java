package com.peaksoft.SpringSecurityMVCToken.exception;

import org.springframework.http.HttpStatus;

public class MyException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public MyException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public MyException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}