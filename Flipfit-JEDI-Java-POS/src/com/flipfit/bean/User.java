package com.flipfit.bean;

public class User extends Person {
    private String userPhone;
    private double userWeight;
    private int[] userSlots;

    public User(String id, String name, String email, String password, String firstName, String lastName) {
        super(id, name, email, password, "USER", firstName, lastName);
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
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
