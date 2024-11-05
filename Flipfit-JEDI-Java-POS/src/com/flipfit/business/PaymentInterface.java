package com.flipfit.business;

public interface PaymentInterface {
    public boolean verifyPaymentCompletion(String userId);
    public void generateInvoice(String userId);
}
