package com.flipfit.service;

import com.flipfit.business.PlansInterface;

public class PlansImpl implements PlansInterface {
    @Override
    public void upgradePlan(){
        System.out.println("upgrading plan");
    }

    @Override
    public void buyPlan(){
        System.out.println("Buying plan");
    }
}
