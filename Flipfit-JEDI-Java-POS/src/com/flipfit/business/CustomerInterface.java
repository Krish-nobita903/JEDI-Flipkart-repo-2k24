package com.flipfit.business;

import com.flipfit.bean.Slot;

import java.util.List;

public interface CustomerInterface {
    public void updateUserInfo(String userId,String phoneNumber,String emailAddress,String password);
    public void cancelSlot(String userId,String SlotId);
    public List<Slot> viewBookedSlots(String userId);
}
