package com.flipfit.exception;

public class DeletionFailedException extends Exception {
    @Override
    public String getMessage(){
        return "Deletion failed. Please try again";
    }
}
