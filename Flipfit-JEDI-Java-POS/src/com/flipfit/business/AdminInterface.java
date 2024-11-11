package com.flipfit.business;

import com.flipfit.bean.Gym;
import com.flipfit.bean.User;

import java.util.List;

public interface AdminInterface {
    public List<User> getUserList();
    public void addGym(String regionId, int pinCode);
    public void updateAdminPassword(String userName,String oldPassword, String newPassword);
}
