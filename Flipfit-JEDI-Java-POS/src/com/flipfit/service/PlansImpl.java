package com.flipfit.service;

import com.flipfit.business.PlansInterface;
import com.flipfit.exception.PaymentFailedException;
import com.flipfit.exception.UpdateFailedException;

public class PlansImpl implements PlansInterface {
    @Override
    public void upgradePlan(){
        try {
            // check if Plan has been upgraded;
            Boolean isPlanUpgraded = true;
            if(!isPlanUpgraded){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("upgrading plan");
        }
    }

    @Override
    public void buyPlan(){
        try {
            // add impl and change if condition to throw error
            Boolean isPlanBought = true;
            if(!isPlanBought){
                throw new PaymentFailedException();
            }
        }
        catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Buying plan");
        }
    }
}
