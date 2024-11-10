package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitGymManagerDAOInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipfitGymManagerDAO;
import com.flipfit.exception.GymListNotFoundException;
import com.flipfit.exception.UpdateFailedException;

import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    FlipfitGymManagerDAO gymManagerDAO = new FlipfitGymManagerDAO();
    @Override
    public List<Gym> viewOwnedGyms(String managerId) {
        try {
            List<Gym> ownedGyms = gymManagerDAO.getOwnedGyms(managerId);
            if(ownedGyms == null){
                throw new GymListNotFoundException();
            }
        }
        catch (GymListNotFoundException e) {
            System.out.println("GymManagerImpl.viewOwnedGyms: " + e.getMessage());
        }
        finally {
            System.out.println("Viewed All Gyms successfully");
        }
        List<Gym> managedGyms = gymManagerDAO.getOwnedGyms(managerId);
        return managedGyms;

    }

    @Override
    public void enrollGym(Gym gym,String managerId) {
        try {
            gymManagerDAO.enrollGym(gym, managerId);
            List<Gym> ownedGyms = gymManagerDAO.getOwnedGyms(managerId);
            Boolean Check=false;
            for(Gym g : ownedGyms){
                if(g.equals(gym)){
                    Check=true;
                }
            }
            if(!Check){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {
            System.out.println("GymManagerImpl.enrollGym: " + e.getMessage());
        }
        finally {
            System.out.println("Gym added successfully");
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
            System.out.println("Slot Updated successfully");
        }
        SlotInterface slot = new SlotImpl();
        slot.updateSlot(null);
    }

    @Override
    public void updateGymDetails(String managerId,String gymId,String PinCode,String RegionId) {
        try {
            Gym gym = gymManagerDAO.getOwnedGyms(managerId).get(0);
            if (PinCode.equalsIgnoreCase("0")) {
                gym.setRegionId(RegionId);
            }
            else{
                int pinCode = Integer.parseInt(PinCode);
                gym.setPinCode(pinCode);
            }
            gymManagerDAO.updateGymDetails(gym);
            List<Gym> ownedGyms = gymManagerDAO.getOwnedGyms(managerId);
            Boolean Check=false;
            for(Gym g : ownedGyms){
                if(g.equals(gym)){
                    Check=true;
                }
            }
            if(!Check){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {
            System.out.println("GymManagerImpl.updateGymDetails: " + e.getMessage());
        }
        finally {
            System.out.println("Gym updated successfully");
        }
    }
}