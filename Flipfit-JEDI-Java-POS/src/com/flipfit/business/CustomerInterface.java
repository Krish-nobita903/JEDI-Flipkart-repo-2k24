package com.flipfit.business;

public interface CustomerInterface {
    public Boolean isSlotAvailable();
    public void updateUserInfo();
    public void cancelBookedSlot();
    public void bookSlot();
}
