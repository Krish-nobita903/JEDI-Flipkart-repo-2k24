package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.bean.User;
import com.flipfit.service.FlipFitUserInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.dao.FlipFitUserDAOImpl;
import com.flipfit.dao.FlipFitUserDAOInterface;
import com.flipfit.dao.FlipFitUserDAOImpl;
import com.flipfit.exception.SlotsUnavailableException;
import com.flipfit.exception.UpdateFailedException;
import com.flipfit.exception.UserNotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipFitUserService implements FlipFitUserInterface {

    private FlipFitUserDAOImpl userDAO = new FlipFitUserDAOImpl();
    private FlipFitSlotDAOInterface flipFitSlotDAO = new FlipFitSlotDAOImpl();

    @Override
    public boolean addUser(String userName,String  email,String  password,String  firstName,String  lastName,String  phoneNumber,double bodyWeight){
        try{
            if(userDAO.createUser(userName,email,password,firstName,lastName,phoneNumber,bodyWeight)){
                return true;
            }
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Slot> viewBookedSlots(String userId){
        // check if viewSlotForUser works properly.
        try {
            int UserId = Integer.parseInt(userId);
            List<String>viewBookedSlotsByUser = flipFitSlotDAO.viewSlotForUser(UserId);
            List<Slot> viewedSlots = flipFitSlotDAO.viewSlots();
            for(String slotId : viewBookedSlotsByUser){
                viewedSlots.add(flipFitSlotDAO.getSlot(slotId));
            }
            if(viewedSlots.isEmpty()){
                throw new SlotsUnavailableException();
            }
            return viewedSlots;
        }
        catch (SlotsUnavailableException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("View Booked slots");
        }
        return new ArrayList<>();
    }

    @Override
    public String login(String userId, String password) {
            String id=userDAO.login(userId, password);
            if(id==null){
                System.out.println("Login failed");
            }
            else {
                System.out.println("Login successful");
            }
            return id;
    }

    @Override
    public void updateUserInfo(String userId,String phoneNumber,String emailAddress,String password) {
        try {
            User user = userDAO.getUserById(userId);
            if(phoneNumber != null){
                user.setUserPhone(phoneNumber);
            }
            else if(emailAddress != null){
                user.setEmail(emailAddress);
            }
            else{
                user.setPassword(password);
            }
            if(!userDAO.updateUser(user)){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("Updating user info");
        }
    }
    @Override
    public void cancelSlot(String userId, String SlotId) {
        try {
            Slot slot = flipFitSlotDAO.getSlot(SlotId);
            flipFitSlotDAO.deleteSlot(slot);
            Slot checkDeletedSlot = flipFitSlotDAO.getSlot(SlotId);
            if(checkDeletedSlot != null){
                throw new SlotsUnavailableException();
            }
        }
        catch (SlotsUnavailableException e) {
            System.err.println(e.getMessage());
        }
        finally {
            System.out.println("Slot deleted successfully");
        }
    }
}