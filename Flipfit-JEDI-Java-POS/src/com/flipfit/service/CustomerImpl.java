package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.bean.User;
import com.flipfit.business.CustomerInterface;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.dao.UserDAO;
import com.flipfit.dao.UserDAOInterface;
import com.flipfit.exception.SlotsUnavailableException;
import com.flipfit.exception.UpdateFailedException;
import com.flipfit.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerImpl implements CustomerInterface {

    private UserDAOInterface userDAO = new UserDAO();
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
        // fetch data from DB for a user.
        try {
            List<Slot> viewedSlots = flipFitSlotDAO.viewSlots();
            List<Slot>viewBookedSlotsByUser = new ArrayList<>();
            for(Slot slot : viewedSlots){
                viewBookedSlotsByUser.add(slot);
            }
            if(viewedSlots.size()==0){
                throw new SlotsUnavailableException();
            }
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
    public void updateUserInfo(String userId) {
        try {
            User user = userDAO.getUserById(userId);
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("What do you want to update?");
            System.out.println("1.Phone number");
            System.out.println("2.Email address");
            System.out.println("3.Password");
            int choice = scanner1.nextInt();
            scanner1.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter Phone Number");
                    String phoneNumber =  scanner1.nextLine();
                    scanner1.nextLine();
                    user.setUserPhone(phoneNumber);
                    break;
                case 2:
                    System.out.println("Enter Email Address");
                    String emailAddress =  scanner1.nextLine();
                    scanner1.nextLine();
                    user.setEmail(emailAddress);
                    break;
                case 3:
                    System.out.println("Enter Password");
                    String password =  scanner1.nextLine();
                    scanner1.nextLine();
                    user.setPassword(password);
                    break;
            }
            userDAO.updateUser(user);
            User updatedUser = new User();
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