package com.flipfit.dao;

import com.flipfit.bean.User;

import java.util.List;

public interface AdminDAOInterface {
    public List<User> getUserList();
    public void addGymManager();
}
