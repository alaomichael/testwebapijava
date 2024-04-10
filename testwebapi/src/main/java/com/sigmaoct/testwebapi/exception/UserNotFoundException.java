package com.sigmaoct.testwebapi.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userid) {
        super("User with id: " + userid + " not found");
    }
}
