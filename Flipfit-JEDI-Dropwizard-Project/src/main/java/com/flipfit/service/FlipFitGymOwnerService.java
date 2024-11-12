package com.flipfit.service;

import com.flipkart.model.*;

import java.util.List;

public interface FlipFitGymOwnerService{

    //public void createGymManager(GymManager gymManager);
    void enrollGym(Gym gym,String managerId);
    public List<Gym> getOwnedGyms(String managerId);
    public void updateGymDetails(Gym updatedGymDetails);
    public void updatePassword(String userName,String oldPassword,String newPassword);
}