package com.flipfit.dao;

public interface RegisterUserInterface {
    public boolean register(String userName, String password, String firstName, String lastName, String email, String phoneNumber, double bodyWeight);
}
