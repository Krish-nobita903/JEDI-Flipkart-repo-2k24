package com.flipfit.dao;

import com.flipfit.bean.User;

import java.util.List;

public interface AdminDAOInterface {
    public boolean addGymManager(String userName,String email,String password,String firstName,String lastName);
    public List<User> getUserList();
}
