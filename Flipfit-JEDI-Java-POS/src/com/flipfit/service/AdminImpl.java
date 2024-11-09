package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.bean.User;
import com.flipfit.business.AdminInterface;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOInterface;
import com.flipfit.dao.GymDAO;
import com.flipfit.dao.GymDAOInterface;

import java.util.ArrayList;
import java.util.List;

public class AdminImpl implements AdminInterface {

    private AdminDAOInterface adminDAO;

    public AdminImpl(){
        adminDAO = new AdminDAO();
    }

    @Override
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();

        try{
            users = adminDAO.getUserList();
        }catch(Exception e){

        }finally {
            System.out.println("Viewing all users.....");
        }

        return users;
    }
}
