package com.flipfit.business;

import com.flipfit.bean.Slot;

import java.util.List;

public interface GymInterface {
    public List<String> viewBookings(String gymId);
    public void updateTrainingsAvailable(String gymId,List<String>updatedTrainings);
    public List<Slot> isAvailableSlots();
}
