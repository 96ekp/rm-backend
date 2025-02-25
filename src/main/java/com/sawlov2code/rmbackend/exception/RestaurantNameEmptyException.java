package com.sawlov2code.rmbackend.exception;

public class RestaurantNameEmptyException extends RuntimeException {
    public RestaurantNameEmptyException(String message) {
        super(message);
    }
}
