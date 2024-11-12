package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.bean.User;
import com.flipfit.dao.AdminDAO;
import com.flipfit.dao.AdminDAOInterface;
import com.flipfit.service.AdminService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceOperation implements AdminService {
    AdminDAO adminDAO = new AdminDAO();

    Scanner obj = new Scanner(System.in);

    @Override
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        try {
            users = adminDAO.getUserList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void addGym(String regionId,int pinCode){
        Slot[] slotsArray = new Slot[0];
        //GymDAO.createGym(regionId,pinCode,slotsArray);
    }

    @Override
    public void addRegion(String regionName){
        adminDAO.addRegion(regionName);
    }

    @Override
    public boolean addAdminUser(String username, String password, String firstName, String lastName, String email){
        try
        {
            if(adminDAO.register(username, password, firstName, lastName, email)){
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void updateAdminPassword(String userName,String newPassword){
        try{
            adminDAO.updateAdminPassword(userName,newPassword);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}