package com.flipfit.exception;

public class WrongCredentialsException extends Exception {
    @Override
    public String getMessage(){
        return "Wrong credentials. Please enter correct credentials.";
    }
}
