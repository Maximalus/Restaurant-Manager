package com.maximalus.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestaurantManagerException extends RuntimeException {
    private HttpStatus httpStatus;

    public RestaurantManagerException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}