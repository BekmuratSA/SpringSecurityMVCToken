package com.peaksoft.SpringSecurityMVCToken.exception;

import lombok.Data;

import java.util.Date;

public class ErrorDTO {

    private Date timestamp;
    public String message;
    public String details;

    public ErrorDTO(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
