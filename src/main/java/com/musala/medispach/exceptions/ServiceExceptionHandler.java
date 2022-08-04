package com.musala.medispach.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(value = {DroneOverloadException.class})
    public ResponseEntity<ErrorResponse> handleSQLIntegrityException(DroneOverloadException ex) {
        String errorMessage =  ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);

        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}
