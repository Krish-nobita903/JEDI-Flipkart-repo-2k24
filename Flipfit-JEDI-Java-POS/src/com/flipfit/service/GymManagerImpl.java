package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;

import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    @Override
    public void updateSlots() {
        System.out.println("Updating Slots");
    }

    @Override
    public List<Gym> viewOwnedGyms() {
        System.out.println("Viewing Owned Gyms");
        return List.of();
    }

    @Override
    public void enrollGym(Gym gym) {
        System.out.println("enrolling gym");
    }

    @Override
    public void updateSlot() {
        System.out.println("Updating Slot");
    }

    @Override
    public void updatedGymDetails(Gym updatedGymDetails) {

    }
}
