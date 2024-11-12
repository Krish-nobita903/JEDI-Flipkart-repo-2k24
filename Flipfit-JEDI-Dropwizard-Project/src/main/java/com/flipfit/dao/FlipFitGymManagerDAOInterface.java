package com.flipfit.dao;

import java.util.List;
import com.flipfit.bean.Gym;

public interface FlipFitGymManagerDAOInterface {

    //public void createGymManager(GymManager gymManager);
    void enrollGym(Gym gym,String managerId);
    public List<Gym> getOwnedGyms(String managerId);
    public void updateGymDetails(Gym updatedGymDetails);
    public void updatePassword(String userName,String oldPassword,String newPassword);
}