package com.flipfit.business;

import com.flipfit.bean.Slot;
import java.util.List;

public interface SlotInterface {
    public boolean addSlot(Slot slot);
    public boolean removeSlot(Slot slot);
    public boolean updateSlot(Slot slot);
    public Slot getSlotByName(String slotName);
    public List<Slot> getSlots();
}
