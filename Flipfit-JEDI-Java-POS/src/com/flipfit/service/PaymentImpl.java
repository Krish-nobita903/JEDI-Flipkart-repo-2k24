package com.flipfit.service;

import com.flipfit.business.PaymentInterface;

public class PaymentImpl implements PaymentInterface {
    @Override
    public boolean verifyPaymentCompletion(String userId) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Payment Successful for" + userId);
        }
        return true;
    }

    @Override
    public void generateInvoice(String userId) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Invoice generated for user " + userId);
        }
    }
}