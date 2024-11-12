package com.flipfit.exception;

public class RegisterationFailedException extends Exception{
    @Override
    public String getMessage() {
        return "Regiteration failed";
    }
}
