package com.flipfit.service;

import com.flipfit.business.bookSlot;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.dao.UserDAOInterface;

public class bookSlotImpl implements bookSlot {

    @Override
    public void cancelBookedSlot() {
        try {

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Cancelling booked slot");
        }
    }
    @Override
    public void bookSlot(){
        try {

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Booking slot");
        }
    }
}