package com.example.demo.Exception;

public class CoursNotFoundException extends RuntimeException {
    public CoursNotFoundException(String message) {
        super(message);
    }

}

