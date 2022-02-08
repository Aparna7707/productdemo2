package com.kibalabs.productdemo.Exception;

public class ResourceAlreadyExistException extends RuntimeException {
    public ResourceAlreadyExistException(String s) {
        super(s);
    }
}
