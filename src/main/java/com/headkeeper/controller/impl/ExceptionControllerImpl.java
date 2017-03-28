package com.headkeeper.controller.impl;

import com.headkeeper.controller.ExceptionController;
import com.headkeeper.exception.ResourceNotFoundException;

public class ExceptionControllerImpl implements ExceptionController {

    public String handleNotFoundException(ResourceNotFoundException e) {
        return "/error-pages/notfound";
    }

    public String handleNotFoundException(Exception e) {
        return "/error-pages/error";
    }
}
