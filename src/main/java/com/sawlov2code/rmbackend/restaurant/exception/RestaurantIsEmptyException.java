package com.sawlov2code.rmbackend.restaurant.exception;

public class RestaurantIsEmptyException extends RuntimeException {
    public RestaurantIsEmptyException(String message) {
        super(message);
    }
}
