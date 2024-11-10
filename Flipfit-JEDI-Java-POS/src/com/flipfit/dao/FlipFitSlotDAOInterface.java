package com.flipfit.dao;

import com.flipfit.bean.Slot;

import java.util.List;

public interface FlipFitSlotDAOInterface {
    void updateSlot(Slot prevSlot, Slot newSlot);
    void addSlot(Slot slot);
    List<Slot> viewSlotsForGym(int gymId);
    void deleteSlot(Slot slot);
    Slot getSlot(String id);
    List<Slot> viewSlots();
    List<String> viewSlotForUser(int userId);
    void cancelBookedSlotForUser(int userId, int slotId);
    void addBookedSlotForUser(int userId, int slotId);
}