package com.flipfit.dao;

import com.flipfit.bean.User;

import java.util.List;

public interface AdminDAOInterface {
    public List<User> getUserList();
    public void addGymManager(String userName,String email,String password,String firstName,String lastName,String gymId);
    public void addRegion(String regionName);
    public void updateAdminPassword(String userName,String newPassword);
}
