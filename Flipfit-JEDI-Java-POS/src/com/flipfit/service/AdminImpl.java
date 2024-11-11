package com.flipfit.service;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.bean.User;
import com.flipfit.business.AdminInterface;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOInterface;
import com.flipfit.dao.GymDAO;
import com.flipfit.dao.GymDAOInterface;
import com.flipfit.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AdminImpl implements AdminInterface {

    private AdminDAOInterface adminDAO;
    private GymDAOInterface gymDAO;
    public AdminImpl(){
        adminDAO = new AdminDAO();
        gymDAO = new GymDAO();
    }

    @Override
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        try{
            users = adminDAO.getUserList();
            if(users.isEmpty()){
                throw new UserNotFoundException();
            }
        }catch(UserNotFoundException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("Viewing all users.....");
        }
        return users;
    }

    @Override
    public void addGym(String regionId, int pinCode){
        try{
            Slot[] slotsArray = new Slot[0];
            if(gymDAO.createGym(regionId, pinCode, slotsArray)){
                System.out.println("Gym added successfully");
            }
            else{
                throw new Exception("Gym creation failed!");
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateAdminPassword(String userName,String oldPassword,String newPassword){
        try{
            adminDAO.updateAdminPassword(userName,oldPassword,newPassword);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
