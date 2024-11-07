package com.flipfit.dao;

import com.flipfit.bean.Slot;

import java.util.List;

public interface FlipFitSlotDAOInterface {
    void updateSlot(Slot prevSlot, Slot newSlot);
    void addSlot(Slot slot);
    List<Slot> viewSlotsForUser(String userId);
    List<Slot> viewSlotsForGym(String gymId);
    void deleteSlot(Slot slot);
    Slot getSlot(String id);
}