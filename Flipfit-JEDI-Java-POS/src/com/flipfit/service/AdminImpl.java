package com.flipfit.service;

import com.flipfit.business.AdminInterface;

public class AdminImpl implements AdminInterface {
    @Override
    public void addUser(){
        System.out.println("User added successfully");
    }

    @Override
    public void addGymOwner(){
        System.out.println("Gym owner added successfully");
    }
}
