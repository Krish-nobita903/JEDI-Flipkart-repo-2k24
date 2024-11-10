package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.GymInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.dao.GymDAO;
import com.flipfit.exception.BookingFailedException;
import com.flipfit.exception.UpdateFailedException;

import java.util.ArrayList;
import java.util.List;

public class GymImpl implements GymInterface {
    FlipFitSlotDAOInterface flipFitSlotDAO;
    @Override
    public List<Slot> viewBookings(String gymId) {
        try {
            int GymId = Integer.parseInt(gymId);
            List<Slot> bookings = flipFitSlotDAO.viewSlotsForGym(GymId);
            if(bookings.size()==0){
                throw new BookingFailedException();
            }
            return bookings;
        }
        catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Retrieving Bookings for Gym " + gymId);
        }
        return List.of();
    }

    @Override
    public void updateTrainingsAvailable(String gymId, List<String> updatedTrainings) {
        try {
            //change this contion and put a condition to check if trainings get updated.
            List<String> fetchedUpdatedTrainings = new ArrayList<>();
            if(updatedTrainings == fetchedUpdatedTrainings){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Updating trainings available for gym " + gymId);
        }
    }

    @Override
    public List<Slot> isAvailableSlots(Integer gymId) {
        try {
            // get gymId from top.
            List<Slot> isSlotFree = flipFitSlotDAO.viewSlotsForGym(gymId);
            if(isSlotFree.isEmpty()){
                throw new BookingFailedException();
            }
            return isSlotFree;
        }
        catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Shows available slots");
        }
        return null;
    }
}
