package com.flipfit.business;

import com.flipfit.bean.Gym;

import java.util.List;

public interface GymManagerInterface {
    public List<Gym> viewOwnedGyms(String managerId);
    public void enrollGym(Gym gym,String managerId);
    public void updateGymDetails(Gym updatedGymDetails);
    public void updatePassword(String userNameForUpdatePassword,String oldPassword,String newPassword);
    void updateSlot();
}
