package com.thalesdeluca.salesapi.Error;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /*@ExceptionHandler(value = { MethodArgumentTypeMismatchException.class, InvalidFormatException.class, HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails typeMismatch(Exception e) {
        return new ErrorDetails(new Date().getTime(), "Argument Type Mismatch", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDetails unknownError(Exception e) {
        return new ErrorDetails(new Date().getTime(), "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }*/


}
