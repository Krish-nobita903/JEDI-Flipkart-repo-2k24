package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.GymInterface;

import java.util.List;

public class GymImpl implements GymInterface {
    @Override
    public List<String> viewBookings(String gymId) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Retrieving Bookings for Gym " + gymId);
        }
        return List.of();
    }

    @Override
    public void updateTrainingsAvailable(String gymId, List<String> updatedTrainings) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Updating trainings available for gym " + gymId);
        }
    }

    @Override
    public List<Slot> isAvailableSlots() {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Shows available slots");
        }
        return null;
    }
}
