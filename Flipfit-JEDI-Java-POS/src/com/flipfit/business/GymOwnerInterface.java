package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;

import java.util.List;

public interface GymOwnerInterface {
    public List<Gym> viewOwnedGyms(GymOwner gymOwner);
    public boolean enrollGym(Gym gym);
    public boolean updateGym(Gym gym);
}
