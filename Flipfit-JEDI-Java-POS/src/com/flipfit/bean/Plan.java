package com.flipfit.bean;

public class Plan {
    private int planId;
    private String planBenefits;
    private double[] planPrices;

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanBenefits() {
        return planBenefits;
    }

    public void setPlanBenefits(String planBenefits) {
        this.planBenefits = planBenefits;
    }

    public double[] getPlanPrices() {
        return planPrices;
    }

    public void setPlanPrices(double[] planPrices) {
        this.planPrices = planPrices;
    }
}
