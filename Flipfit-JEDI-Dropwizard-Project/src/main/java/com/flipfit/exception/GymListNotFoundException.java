package com.flipfit.exception;

public class GymListNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "GymList not found";
    }
}
