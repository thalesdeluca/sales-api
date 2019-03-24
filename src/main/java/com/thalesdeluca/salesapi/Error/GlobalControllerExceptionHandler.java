package com.thalesdeluca.salesapi.Error;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import java.util.Date;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentTypeMismatchException.class, InvalidFormatException.class, HttpMessageNotReadableException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails typeMismatch(Exception e) {
        return new ErrorDetails(new Date().getTime(), "Argument Type Mismatch", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails notFound(Exception e) {
        return new ErrorDetails(new Date().getTime(), "Not Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { MissingServletRequestParameterException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails missingParameter(Exception e) {
        return new ErrorDetails(new Date().getTime(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { ConstraintViolationException.class, org.hibernate.exception.ConstraintViolationException.class, RollbackException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails missingParameterBody(Exception e) {
        return new ErrorDetails(new Date().getTime(), "Missing parameters in body", HttpStatus.BAD_REQUEST);
    }

}
