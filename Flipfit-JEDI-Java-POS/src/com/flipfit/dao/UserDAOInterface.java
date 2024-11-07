package com.flipfit.dao;

import com.flipfit.bean.User;

public interface UserDAOInterface {
    public boolean createUser(String userName, String email, String password, String firstName, String lastName);
    public boolean updateUser(User user);
    public boolean deleteUser(String id);
}
