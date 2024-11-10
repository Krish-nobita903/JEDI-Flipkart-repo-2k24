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
            Boolean isSlotAdded = true;
            if(!isSlotAdded){
                throw new SlotInesrtionFailedException();
            }
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
            Boolean isSlotUpdated = true;
            if(!isSlotUpdated){
                throw new UpdateFailedException();
            }
        }
        catch (UpdateFailedException e) {

        }
        finally {
            System.out.println("Slot has been updated!");
        }
        return false;
    }

    @Override
    public boolean deleteSlot(Slot slot) {
        try {
            Boolean isSlotDeleted = true;
            if(!isSlotDeleted){
                throw new DeletionFailedException();
            }
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
