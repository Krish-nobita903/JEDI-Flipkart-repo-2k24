package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.CustomerInterface;

import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerInterface {
    @Override
    public void viewUserPlan(){
        System.out.println("View User Plan");
    }
    @Override
    public List<Slot> viewBookedSlots(){
        System.out.println("View Booked slots");
        return new ArrayList<>();
    }

    @Override
    public void cancelSlot(){
        System.out.println("Slot deleted successfully");
    }

    @Override
    public void updateUserInfo() {
        System.out.println("Updating user info");
    }
}
