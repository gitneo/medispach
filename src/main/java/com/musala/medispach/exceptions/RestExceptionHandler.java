package com.musala.medispach.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleSQLIntegrityException(HttpServletRequest req, SQLIntegrityConstraintViolationException ex){
        String errorMessage = "Unable to submit post: " + ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errorMessage);

        return new ResponseEntity<>(errorResponse,errorResponse.getHttpStatus());
    }


    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(HttpServletRequest request, NoSuchElementException ex){
        String errorMessage = "The row for the address is not existent " + request.getRequestURI();
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND,errorMessage);

        return new ResponseEntity<>(errorResponse,errorResponse.getHttpStatus());
    }

}
