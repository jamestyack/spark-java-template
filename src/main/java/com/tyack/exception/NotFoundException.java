package com.tyack.exception;

/**
 * Created by jamestyack on 11/15/15.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super(id + " not found.");
    }
}
