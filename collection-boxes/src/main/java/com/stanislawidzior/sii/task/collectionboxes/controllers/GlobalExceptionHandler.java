package com.stanislawidzior.sii.task.collectionboxes.controllers;

import com.stanislawidzior.sii.task.collectionboxes.dtos.response.ErrorResponse;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.ConstraintException;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.DeserializationException;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.InvalidRequestException;
import com.stanislawidzior.sii.task.collectionboxes.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(e.getMessage(), "INTERNAL_SERVER_ERROR");
    }
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException e) {
        return new ErrorResponse(e.getMessage(), "NOT_FOUND");
    }
    @ExceptionHandler(ConstraintException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationExceptions(ConstraintException e) {
        return new ErrorResponse(e.getMessage(), "CONSTRAINT_ERROR");
    }
    @ExceptionHandler(DeserializationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDeserializationExceptions(DeserializationException e) {
        return new ErrorResponse(e.getMessage(), "DESERIALIZATION_ERROR");
    }
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidRequestExceptions(InvalidRequestException e) {
        return new ErrorResponse(e.getMessage(), "BUSINESS_LOGIC_ERROR");
    }
}

