package com.flipfit.service;

import com.flipfit.business.bookSlot;

public class bookSlotImpl implements bookSlot {
    @Override
    public void cancelBookedSlot() {
        System.out.println("Cancelling booked slot");
    }
    @Override
    public void bookSlot(){
        System.out.println("Booking slot");
    }
}
