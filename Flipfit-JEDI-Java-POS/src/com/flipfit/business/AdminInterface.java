package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymManager;
import com.flipfit.bean.User;

import java.util.List;

public interface AdminInterface {
    //public void addGymOwner();
    public List<User> getUserList();
}
