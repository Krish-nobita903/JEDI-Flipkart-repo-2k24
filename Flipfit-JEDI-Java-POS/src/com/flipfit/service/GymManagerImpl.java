package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitGymManagerDAOInterface;
import com.flipfit.dao.FlipFitGymManagerDao;

import java.util.ArrayList;
import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    @Override
    public List<Gym> viewOwnedGyms() {
        FlipFitGymManagerDAOInterface gymManagerDAO = new FlipFitGymManagerDAO();
        List<Gym> managedGyms = FlipFitGymManagerDAOInterface.
        return managedGyms;
    }

    @Override
    public void enrollGym(Gym gym) {
        System.out.println("enrolling gym");
    }

    @Override
    public void updateSlot() {
        SlotInterface slot = new SlotImpl();
        slot.updateSlot(null);
    }

    @Override
    public void updatedGymDetails(Gym updatedGymDetails) {

    }
}
