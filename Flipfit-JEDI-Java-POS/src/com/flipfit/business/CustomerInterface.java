package com.flipfit.business;

import com.flipfit.bean.Slot;

import java.util.List;

public interface CustomerInterface {
    public void updateUserInfo();
    public void viewUserPlan();
    public void cancelSlot();
    public List<Slot> viewBookedSlots();
}
