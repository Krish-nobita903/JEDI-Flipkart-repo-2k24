package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.GymInterface;
import com.flipfit.exception.BookingFailedException;
import com.flipfit.exception.UpdateFailedException;

import java.util.ArrayList;
import java.util.List;

public class GymImpl implements GymInterface {
    @Override
    public List<String> viewBookings(String gymId) {
        try {
            List<String> bookings = new ArrayList<>();
            if(bookings.size()==0){
                throw new BookingFailedException();
            }
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
    public List<Slot> isAvailableSlots() {
        try {
            // write a condition to check in impl.
            Boolean isSlotFree = false;
            if(isSlotFree == false){
                throw new BookingFailedException();
            }
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
