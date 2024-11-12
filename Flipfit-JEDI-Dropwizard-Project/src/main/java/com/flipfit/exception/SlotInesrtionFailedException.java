package com.flipfit.exception;

public class SlotInesrtionFailedException extends Exception {
    @Override
    public String getMessage(){
        return "Slot Insertion Failed";
    }
}
