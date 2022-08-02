package com.musala.medispach.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyyMMdd hh:mm:ss")
    private LocalDateTime timeStamp;
    private String message;

    public ErrorResponse(HttpStatus status) {
        this.httpStatus = status;
    }

    public ErrorResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, String message) {
        this();
        this.httpStatus = status;
        this.message = message;
    }
}
