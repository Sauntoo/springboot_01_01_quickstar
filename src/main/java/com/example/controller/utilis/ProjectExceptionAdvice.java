package com.example.controller.utilis;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public res doException(Exception ex){


        ex.printStackTrace();
        return new res("服务器故障，请稍后再试");
    }
}
