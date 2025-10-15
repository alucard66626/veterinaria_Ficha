package com.example.veterinaria.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.veterinaria.exception.VeterinariaException;
import com.example.veterinaria.dto.Error;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(exception = VeterinariaException.class)
    public ResponseEntity<Error> handleException(VeterinariaException exception){

        return ResponseEntity.badRequest().body(new Error(exception.getMensaje(), HttpStatus.BAD_REQUEST.value()));
    }
}
