package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitGymManagerDAOInterface;

import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    FlipFitGymManagerDAO gymManagerDAO = new FlipFitGymManagerDAO();
    @Override
    public List<Gym> viewOwnedGyms(String managerId) {
        List<Gym> managedGyms = gymManagerDAO.getOwnedGyms(managerId);
        return managedGyms;

    }

    @Override
    public void enrollGym(Gym gym,String managerId) {
        gymManagerDAO.enrollGym(gym,managerId);
        System.out.println("enrolling gym");
    }

    @Override
    public void updateSlot() {
        SlotInterface slot = new SlotImpl();
        slot.updateSlot(null);
    }

//    @Override
//    //public void updatedGymDetails(Gym updatedGymDetails) {
//        gymManagerDAO.updatedGymDetails(updatedGymDetails);
//    }
}
