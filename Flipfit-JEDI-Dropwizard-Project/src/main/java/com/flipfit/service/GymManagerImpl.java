package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.business.GymManagerInterface;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipfitGymManagerDAO;
import com.flipfit.exception.GymListNotFoundException;
import com.flipfit.exception.UpdateFailedException;

import java.util.List;

public class GymManagerImpl implements GymManagerInterface {
    FlipfitGymManagerDAO gymManagerDAO = new FlipfitGymManagerDAO();

    @Override
    public boolean createGymManager(String name,String email,String password, String firstName, String lastName){
        try{
            return gymManagerDAO.register(name,email,password,firstName,lastName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Gym> viewOwnedGyms(String managerId) {
        List<Gym> managedGyms = null;
        try {
            managedGyms = gymManagerDAO.getOwnedGyms(managerId);
            if(managedGyms == null){
                throw new GymListNotFoundException();
            }
            for(Gym gym : managedGyms){
                System.out.println("Gym id: " + gym.gymId() + " Region id: " + gym.region() + " Pincode: " + gym.pinCode());
            }
        }
        catch (GymListNotFoundException e) {
            System.out.println("GymManagerImpl.viewOwnedGyms: " + e.getMessage());
        }
        finally {
            System.out.println("Viewed All Gyms successfully");
        }
        return managedGyms;
    }

    @Override
    public void enrollGym(Gym gym,String managerId) {
        try {
            gymManagerDAO.enrollGym(gym, managerId);
        }
        catch (Exception e) {
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

    @Override
    public void updatePassword(String userName,String oldPassword,String newPassword)
    {
        try{
            gymManagerDAO.updatePassword(userName,oldPassword,newPassword);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}