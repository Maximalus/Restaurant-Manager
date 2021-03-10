package com.maximalus.exception;

import java.util.function.Supplier;

public class RestaurantManagerException extends RuntimeException {
    public RestaurantManagerException(String message) {
        super(message);
    }
}
