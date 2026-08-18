package com.cinema.booking.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resource, Object value) {
        super(resource + " not found with value: " + value);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
