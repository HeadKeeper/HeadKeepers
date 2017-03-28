package com.headkeeper.controller;

import com.headkeeper.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public interface ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    String handleNotFoundException(ResourceNotFoundException e);

    @ExceptionHandler(Exception.class)
    String handleNotFoundException(Exception e);
}
