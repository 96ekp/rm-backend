package com.sawlov2code.rmbackend.globalException;

import com.sawlov2code.rmbackend.exception.RestaurantNameEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RestaurantNameEmptyException.class)
    public ResponseEntity<Object> handleRestaurantNameEmptyException(RestaurantNameEmptyException ex, WebRequest request) {
        Map<String, Object> body  = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("error", "Bad Request");
        body.put("message", ex.getMessage());
        body.put("path", request.getDescription(false).substring(4));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}
