package com.sawlov2code.rmbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestaurantAlreadyExistsException.class)
    public ResponseEntity<Object> handleRestaurantNameEmptyException(RestaurantAlreadyExistsException ex, WebRequest request) {
        Map<String, Object> body  = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestaurantIsEmptyException.class)
    public ResponseEntity<Object> handleRestaurantIsEmptyException(RestaurantIsEmptyException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Object> handleRestaurantNotFoundException(RestaurantNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MenuNotFoundException.class)
    public ResponseEntity<Object> handleMenuNotFoundException(MenuNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND);
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
