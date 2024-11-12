package com.flipfit.service;

import com.flipfit.bean.Slot;

import java.util.List;

public interface FlipFitUserInterface {
    public void updateUserInfo(String userId,String phoneNumber,String emailAddress,String password);
    public void cancelSlot(String userId,String SlotId);
    public List<Slot> viewBookedSlots(String userId);
    public String login(String userId,String password);
    public boolean addUser(String userName,String  email,String  password,String  firstName,String  lastName,String  phoneNumber,double bodyWeight);
}
