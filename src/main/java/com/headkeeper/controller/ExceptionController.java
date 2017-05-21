package com.headkeeper.controller;

import com.headkeeper.bean.view.ResultView;
import com.headkeeper.controller.exception.ControllerException;
import com.headkeeper.controller.exception.ExistsControllerException;
import com.headkeeper.controller.exception.NotFoundControllerException;
import com.headkeeper.controller.exception.WrongInputControllerException;
import com.headkeeper.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.headkeeper.controller")
public class ExceptionController {
    @ExceptionHandler(NotFoundControllerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResultView notFoundExceptionHandler(NotFoundControllerException exception) {
        System.out.println("Not found");
        // TODO: Log
        return getErrorMessage(exception);
    }

    @ExceptionHandler(ExistsControllerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultView existsExceptionHandler(ExistsControllerException exception) {
        System.out.println("Exists");
        // TODO: Log
        return getErrorMessage(exception);
    }

    @ExceptionHandler(WrongInputControllerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultView wrongInputExceptionHandler(WrongInputControllerException exception) {
        System.out.println("Wrong input");
        // TODO: Log
        return getErrorMessage(exception);
    }

    @ExceptionHandler(ControllerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultView controllerExceptionHandler(ControllerException exception) {
        System.out.println("Controller error");
        // TODO: Log
        return getErrorMessage(exception);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResultView validationExceptionHandler(ValidationException exception) {
        System.out.println("Validation error");
        // TODO: Log
        return getErrorMessage(exception);
    }

    private ResultView getErrorMessage(Exception exception) {
        ResultView result = new ResultView();
        result.setText(exception.getMessage());
        return result;
    }
}
