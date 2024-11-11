package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.SlotInterface;
import com.flipfit.dao.FlipFitSlotDAOInterface;
import com.flipfit.exception.DeletionFailedException;
import com.flipfit.exception.SlotInesrtionFailedException;
import com.flipfit.exception.SlotsUnavailableException;
import com.flipfit.exception.UpdateFailedException;

public class SlotImpl implements SlotInterface {
    FlipFitSlotDAOInterface slotDAO;
    @Override
    public boolean addSlot(Slot slot) {
        try {
            // add impl and change if condition
            slotDAO.addSlot(slot);
            String slotId = slot.getSlotId();
            Slot newSlot = slotDAO.getSlot(slotId);
            if(newSlot == null){
                throw new SlotInesrtionFailedException();
            }
            return true;
        }
        catch (SlotInesrtionFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Added Slot successfully");
        }
        return false;
    }

    @Override
    public boolean updateSlot(Slot slot) {
        try {
            // add impl and change if condition
            String slotId = slot.getSlotId();
            Slot oldSlot = slotDAO.getSlot(slotId);
            slotDAO.updateSlot(oldSlot, slot);
            Slot newSlot = slotDAO.getSlot(slotId);
            if(!oldSlot.equals(newSlot)){
                throw new UpdateFailedException();
            }
            return true;
        }
        catch (UpdateFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Slot has been updated!");
        }
        return false;
    }

    @Override
    public boolean deleteSlot(Slot slot) {
        try {
            slotDAO.deleteSlot(slot);
            String slotId = slot.getSlotId();
            Slot deletedSlot = slotDAO.getSlot(slotId);
            if(deletedSlot != null){
                throw new DeletionFailedException();
            }
            return true;
        }
        catch (DeletionFailedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Slot Deleted Successfully!");
        }
        return false;
    }

    @Override
    public Slot viewSlotById(int id) {
        try {
            String SlotId = Integer.toString(id);
            Slot slot = slotDAO.getSlot(SlotId);
            if(slot == null){
                throw new SlotsUnavailableException();
            }
        }
        catch (SlotsUnavailableException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("View Slot");
        }
        return null;
    }
}
