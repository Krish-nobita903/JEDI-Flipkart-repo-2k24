package com.flipfit.service;

import com.flipfit.business.PaymentInterface;
import com.flipfit.exception.PaymentFailedException;

public class PaymentImpl implements PaymentInterface {

    @Override
    public boolean verifyPaymentCompletion(String userId) {
        try {
            // make payment impl and check if its success and change if condition
            Boolean paymentSuccess = true;
            if(!paymentSuccess){
                throw new PaymentFailedException();
            }
        }
        catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Invoice generated for user " + userId);
        }
    }
}