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
    public boolean removeSlot(Slot slot) {
        return false;
    }

    @Override
    public boolean updateSlot(Slot slot) {
        return false;
    }

    @Override
    public Slot getSlotByName(String slotName) {
        return null;
    }

    @Override
    public List<Slot> getSlots() {
        return List.of();
    }
}
