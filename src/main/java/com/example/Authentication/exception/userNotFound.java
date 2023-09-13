package com.example.Authentication.exception;

public class userNotFound extends RuntimeException{

    public userNotFound(String message) {
        super(message);
    }

    public userNotFound(Throwable cause) {
        super(cause);
    }
}
