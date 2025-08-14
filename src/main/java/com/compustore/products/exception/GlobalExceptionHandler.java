package com.compustore.products.exception;

import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String,Object>> handleValidation(MethodArgumentNotValidException ex){
    Map<String,String> errors = new HashMap<>();
    for (FieldError fe : ex.getBindingResult().getFieldErrors()) errors.put(fe.getField(), fe.getDefaultMessage());
    return ResponseEntity.badRequest().body(Map.of("status",400,"errors",errors));
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<Map<String,Object>> handleNotFound(NoSuchElementException ex){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status",404,"error","Not Found"));
  }
}
