package com.thalesdeluca.salesapi.Error;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {
    private long timestamp;
    private String message;
    private HttpStatus status;


    public ErrorDetails(long timestamp, String message, HttpStatus status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
