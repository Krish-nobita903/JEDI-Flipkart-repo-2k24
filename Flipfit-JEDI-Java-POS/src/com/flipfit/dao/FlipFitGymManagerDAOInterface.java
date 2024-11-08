package com.flipfit.dao;
import java.util.List;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymManager;
import java.util.List;

public interface FlipFitGymManagerDAOInterface {

        //public void createGymManager(GymManager gymManager);
        void enrollGym(Gym gym,String managerId);
        public List<Gym> getOwnedGyms(String managerId);
        public void updateGymDetails(Gym updatedGymDetails);

}
