package com.flipfit.dao;
import java.util.List;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymManager;
import java.util.List;

public interface FlipFitGymManagerDAOInterface {

        List<Gym> getOwnedGyms(String managerId);
        void updateSlotForGym(String gymId, String slot);
        void updateTrainingsForGym(String gymId, List<String> updatedTrainings);

        boolean hasAvailableSlots();

}
