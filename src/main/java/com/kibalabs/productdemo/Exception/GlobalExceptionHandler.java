package com.kibalabs.productdemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<String> resourceAlreadyExistException(ResourceAlreadyExistException resourceAlreadyExistException){
        return new ResponseEntity<String>( "PRODUCT ALREADY EXIST", HttpStatus.CONFLICT );
    }
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> emptyInputException(EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Fields should not be empty:",HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<String>("PRODUCT NOT FOUND:",HttpStatus.BAD_REQUEST);
    }

}
