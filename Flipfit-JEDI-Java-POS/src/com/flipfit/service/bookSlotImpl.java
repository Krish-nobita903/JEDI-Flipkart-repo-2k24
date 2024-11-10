package com.flipfit.service;

import com.flipfit.business.bookSlot;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.dao.UserDAOInterface;

public class bookSlotImpl implements bookSlot {
    FlipFitSlotDAOInterface flipFitSlotDAO = new FlipFitSlotDAOImpl();
    @Override
    public void cancelBookedSlot(int userId, int slotId) {
        try {
            flipFitSlotDAO.cancelBookedSlotForUser(userId, slotId);
            System.out.println("Canceled booked slot " + slotId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Cancelling booked slot");
        }
    }
    @Override
    public void bookSlot(int userId, int slotId) {
        try {
            flipFitSlotDAO.addBookedSlotForUser(userId, slotId);
            System.out.println("Booked slot " + slotId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Booking slot");
        }
    }
}