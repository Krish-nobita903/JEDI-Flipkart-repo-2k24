package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.bookSlot;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;

import java.util.List;
import java.util.Random;

public class bookSlotImpl implements bookSlot {
    FlipFitSlotDAOInterface flipFitSlotDAO = new FlipFitSlotDAOImpl();
    @Override
    public void cancelBookedSlot(String userId, String bookingId) {
        try {
            int UserId = Integer.parseInt(userId);
            List<String> bookedSlots = flipFitSlotDAO.viewSlotForUser(UserId);
            Slot slot = flipFitSlotDAO.getSlot(bookingId);
            flipFitSlotDAO.deleteSlot(slot);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Cancelling booked slot");
        }
    }
    @Override
    public void bookSlot(String userId){
        try {
            int UserId = Integer.parseInt(userId);
            Random random = new Random();
            int bookingId = random.nextInt();
            flipFitSlotDAO.bookSlot(UserId,bookingId);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Booking slot");
        }
    }
}