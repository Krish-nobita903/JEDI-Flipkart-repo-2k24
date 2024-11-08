package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitGymManagerDAOInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;

import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    FlipFitGymManagerDAOInterface gymManagerDAO = new FlipFitGymManagerDAO();
    @Override
    public List<Gym> viewOwnedGyms(String managerId) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Gym owner added successfully");
        }
        List<Gym> managedGyms = gymManagerDAO.getOwnedGyms(managerId);
        return managedGyms;

    }

    @Override
    public void enrollGym(Gym gym,String managerId) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Gym owner added successfully");
        }
        gymManagerDAO.enrollGym(gym,managerId);
        System.out.println("enrolling gym");
    }

    @Override
    public void updateSlot() {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Gym owner added successfully");
        }
        SlotInterface slot = new SlotImpl();
        slot.updateSlot(null);
    }

    @Override
    public void updatedGymDetails(Gym updatedGymDetails) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Gym owner added successfully");
        }
        gymManagerDAO.updatedGymDetails(updatedGymDetails);
    }
}
