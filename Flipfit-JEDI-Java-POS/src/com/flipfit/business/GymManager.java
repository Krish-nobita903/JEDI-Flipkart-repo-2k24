package com.flipfit.business;

import com.flipfit.bean.Gym;

import java.util.List;

public interface GymManager {
    public void updateSlots();
    public List<Gym> viewOwnedGyms();
    public void enrollGym(Gym gym);
    public void updatedGymDetails(Gym updatedGymDetails);
}
