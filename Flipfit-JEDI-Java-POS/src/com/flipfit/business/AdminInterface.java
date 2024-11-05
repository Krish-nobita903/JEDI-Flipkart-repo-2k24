package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.User;

public interface AdminInterface {
    public User addUser(String username, String password, String email, String firstName, String lastName);
    public GymOwner addGymOwner(String username, String password, String email, String firstName, String lastName, Gym gym);
}
