package com.kibalabs.productdemo.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String a) {
        super(a);
    }
}
