package com.flipfit.business;

public interface bookSlot {
    public void cancelBookedSlot(String userId, String slotId);
    public void bookSlot(String userId);

}
