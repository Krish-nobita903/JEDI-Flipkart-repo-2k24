package com.flipfit.service;

import com.flipfit.bean.User;

import java.util.List;

public interface AdminService {
    public List<User> getUserList();
    public void addGym(String regionId,int pinCode);
    public void addRegion(String regionName);
    public void updateAdminPassword(String userName,String newPassword);
    public String login(String userName,String password);
    public boolean addAdminUser(String username, String password, String firstName, String lastName, String email);
}
