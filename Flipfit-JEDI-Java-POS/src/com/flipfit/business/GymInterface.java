package com.flipfit.business;

import java.util.List;

public interface GymInterface {
    public List<String> viewBookings(String gymId);
    public void updateTrainingsAvailable(String gymId,List<String>updatedTrainings);
    public Boolean isAvailableSlots();
}
