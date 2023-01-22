package com.afrivera.pruebanexsys.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    // metodo para enviar errores de validación de campos en el momento de hacer un post
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach( error -> {
            String key = ((FieldError)error).getField();
            String value = error.getDefaultMessage();
            errors.put(key, value);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
