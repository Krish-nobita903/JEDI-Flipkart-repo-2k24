package com.flipfit.service;

import com.flipfit.bean.*;
import com.flipfit.dao.FlipFitUserDAOImpl;
import com.flipfit.dao.FlipFitUserDAOInterface;

import java.util.*;

public class FlipFitUserService implements FlipFitUserInterface{
    private FlipFitUserDAOInterface userDAO = new FlipFitUserDAOImpl();
    private FlipFitSlotDAOInterface flipFitSlotDAO = new FlipFitSlotDAOImpl();

    //    @Override
//    public void viewUserPlan(){
//        try {
//            // take user from DB.
//            User user = new User();
//            if(user== null){
//                throw new UserNotFoundException();
//            }
//        }
//        catch (UserNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        finally {
//            System.out.println("View User Plan");
//        }
//    }
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
    public void updateUserInfo(String userId,String phoneNumber,String emailAddress,String password) {
        try {
            User user = userDAO.getUserById(userId);
            if(!phoneNumber.equalsIgnoreCase("0")){
                user.setUserPhone(phoneNumber);
            }
            if(!emailAddress.equalsIgnoreCase("0")){
                user.setEmail(emailAddress);
            }
            if(!password.equalsIgnoreCase("0")){
                user.setPassword(password);
            }
            userDAO.updateUser(user);
            User updatedUser = userDAO.getUserById(userId);
            if(user != updatedUser){
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