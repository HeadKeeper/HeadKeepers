package com.headkeeper.controller;

import com.headkeeper.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.headkeeper.controller")
public interface ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    //TODO: Write correct exceptions handlers
    String handleNotFoundException(ResourceNotFoundException e);

    @ExceptionHandler(Exception.class)
    String handleNotFoundException(Exception e);
}
