package com.flipfit.service;

import com.flipfit.business.CustomerInterface;

public class CustomerImpl implements CustomerInterface {
    @Override
    public Boolean isSlotAvailable() {
        System.out.println("Checking if Slot Available");
        return null;
    }

    @Override
    public void updateUserInfo() {
        System.out.println("Updating user info");
    }

    @Override
    public void cancelBookedSlot() {
        System.out.println("Cancelling booked slot");
    }

    @Override
    public void bookSlot() {
        System.out.println("Booking slot");
    }
}
