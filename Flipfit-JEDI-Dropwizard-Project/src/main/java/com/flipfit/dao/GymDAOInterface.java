package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import java.util.List;

public interface GymDAOInterface {
    public boolean createGym(String regionId, int pincode, Slot[] slotsAvailable);
    public boolean updateGym(Gym gym);
    public Gym viewGym(String gymId);
    public boolean deleteGym(String gymId);
}