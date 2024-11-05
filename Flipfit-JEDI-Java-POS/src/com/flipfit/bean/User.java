package com.flipfit.bean;

<<<<<<< HEAD
public class User {
    private String userId;
=======
public class User extends Person {
    private int userId;
>>>>>>> 878e862 (Added a super class for admin, user and gym owner, along with interfaces)
    private String userPhone;
    private double userWeight;
    private int[] userSlots;

<<<<<<< HEAD
    public String getUserId() {
=======
    public User(String id, String name, String email, String password, String firstName, String lastName) {
        super(id, name, email, password, "ADMIN", firstName, lastName);
    }

    public int getUserId() {
>>>>>>> 878e862 (Added a super class for admin, user and gym owner, along with interfaces)
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
