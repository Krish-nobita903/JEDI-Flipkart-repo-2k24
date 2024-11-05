package com.flipfit.service;

import com.flipfit.business.GymInterface;

import java.util.List;

public class GymImpl implements GymInterface {
    @Override
    public List<String> viewBookings(String gymId) {
        System.out.println("Retrieving Bookings for Gym " + gymId);
        return List.of();
    }

    @Override
    public void updateTrainingsAvailable(String gymId, List<String> updatedTrainings) {
        System.out.println("Updating trainings available for gym " + gymId);
    }
}
