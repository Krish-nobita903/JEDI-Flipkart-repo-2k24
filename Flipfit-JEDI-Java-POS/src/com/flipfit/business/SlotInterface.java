package com.flipfit.business;

import com.flipfit.bean.Slot;
import java.util.List;

public interface SlotInterface {
    public boolean addSlot(Slot slot);
    public Slot viewSlotById(int id);
    public boolean updateSlot(Slot slot);
    public boolean deleteSlot(Slot slot);
}
