package com.example.railwaystations_proj.exc_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler
    private ResponseEntity<NoSuchInfo> handleException(NoSuchInfoException exception){
        NoSuchInfo noSuchInfo = new NoSuchInfo(exception.getMessage());
        return new ResponseEntity<>(noSuchInfo, HttpStatus.NOT_FOUND);
    }
}
