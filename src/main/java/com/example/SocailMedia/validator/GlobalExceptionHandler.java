package com.example.SocailMedia.validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return errors;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Map<String, String> handleTypeMismatchExceptions(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(ex.getName(), "Invalid type for " + ex.getName() + ": " + ex.getValue());
        return errors;
    }
}
