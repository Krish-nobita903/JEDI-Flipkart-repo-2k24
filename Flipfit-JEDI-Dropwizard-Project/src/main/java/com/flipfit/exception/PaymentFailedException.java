package com.flipfit.exception;

public class PaymentFailedException extends Exception {
    @Override
    public String getMessage() {
        return "Payment failed";
    }
}
