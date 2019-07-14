package com.example.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public static void handlerException(Exception e) {
        String stackTrace = e.getStackTrace().length>0?e.getStackTrace()[0].toString():"";
        String errorMsg = "系统未捕获的异常handlerException：error:"+e.toString()+"\n"+"stackTrace:"+stackTrace;
        System.out.println(errorMsg);
        LOGGER.error(errorMsg);
    }

}
