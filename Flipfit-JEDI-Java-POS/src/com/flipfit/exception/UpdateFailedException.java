package com.flipfit.exception;

public class UpdateFailedException extends Exception {
    @Override
    public String getMessage(){
        return "Update User failed. Please try again";
    }
}
