package com.mjt.todoapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    // Constructor to initialize the exception with a custom message
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
