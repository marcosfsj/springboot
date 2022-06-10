package com.getcrackingtutorials.springboot.controller.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String code;
    private String message;
    private String details;
}
