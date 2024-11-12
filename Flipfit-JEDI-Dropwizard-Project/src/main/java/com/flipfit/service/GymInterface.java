package com.flipfit.service;

import com.flipfit.bean.Slot;

import java.util.List;

public interface GymInterface {
    public List<Slot> viewBookings(String gymId);
    public void updateTrainingsAvailable(String gymId,List<String>updatedTrainings);
    public List<Slot> isAvailableSlots(Integer gymId);
}
