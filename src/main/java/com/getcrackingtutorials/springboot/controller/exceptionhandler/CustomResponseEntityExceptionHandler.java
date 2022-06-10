package com.getcrackingtutorials.springboot.controller.exceptionhandler;

import com.getcrackingtutorials.springboot.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse("general.exception", ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse("not.found", ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse("bad.data", "Validation Failed", ex.getBindingResult().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

}
