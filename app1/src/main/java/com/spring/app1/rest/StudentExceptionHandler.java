package com.spring.app1.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handelException(StudentNotFound e) {
        return new ResponseEntity<>(
                StudentErrorResponse.create(404, e.getMessage(), System.currentTimeMillis()
                ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handelException(Exception e) {
        StudentErrorResponse se = StudentErrorResponse.create(
                HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(se, HttpStatus.BAD_REQUEST);
    }

}
