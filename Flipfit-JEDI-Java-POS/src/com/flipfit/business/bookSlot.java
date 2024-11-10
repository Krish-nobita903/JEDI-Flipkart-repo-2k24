package com.flipfit.business;

public interface bookSlot {
    public void cancelBookedSlot(int userId, int slotId);
    public void bookSlot(int userId, int slotId);

}
