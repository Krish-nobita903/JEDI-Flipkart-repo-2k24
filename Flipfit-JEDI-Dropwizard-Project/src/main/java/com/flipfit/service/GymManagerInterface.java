package com.flipfit.service;

import com.flipfit.bean.*;

import java.util.List;

public interface GymManagerInterface {
    public List<Gym> viewOwnedGyms(String managerId);
    public void enrollGym(Gym gym,String managerId);
    public void updateGymDetails(String managerId,String managerOwnedGymId,String PinCode,String RegionId);
    void updateSlot();
    void updatePassword(String userName,String oldPassword,String newPassword);
}