package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.SlotInterface;

import java.util.List;

public class SlotImpl implements SlotInterface {
    @Override
    public boolean addSlot(Slot slot) {
        return false;
    }

    @Override
    public boolean updateSlot(Slot slot) {
        System.out.println("Slot has been updated!");
        return false;
    }

    @Override
    public boolean deleteSlot(Slot slot) { return false; }

    @Override
    public Slot viewSlotById(int id) {
        return null;
    }
}
