package com.flipfit.bean;

public class User {
    private String userId;
    private String userPhone;
    private double userWeight;
    private int[] userSlots;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserName(String userPhone) {
        this.userPhone = userPhone;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public int[] getUserSlots() {
        return userSlots;
    }

    public void setUserSlots(int[] userSlots) {
        this.userSlots = userSlots;
    }
}
