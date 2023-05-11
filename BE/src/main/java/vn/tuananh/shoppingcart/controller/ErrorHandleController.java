package vn.tuananh.shoppingcart.controller;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.tuananh.shoppingcart.exception.NotFoundException;
import vn.tuananh.shoppingcart.model.ErrorResponse;

@RestControllerAdvice
public class ErrorHandleController {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex){
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
