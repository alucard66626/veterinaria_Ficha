package com.example.veterinaria.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    
    
    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleArgumentNotValidException(MethodArgumentNotValidException exception){
    	
    	MethodArgumentNotValidException ERROR = exception;
        String Errores = "";
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();          
            String errorUni = "("+fieldName + "): " +errorMessage;   
            Errores  = Errores.length() > 0 ? (Errores+", "+errorUni):errorUni;
        }
  
        return ResponseEntity.badRequest().body(new Error(Errores, HttpStatus.BAD_REQUEST.value()));
        //return ResponseEntity.badRequest().body(new Error(exception.getMessage(), HttpStatus.BAD_REQUEST.value()));
    }
    
}
