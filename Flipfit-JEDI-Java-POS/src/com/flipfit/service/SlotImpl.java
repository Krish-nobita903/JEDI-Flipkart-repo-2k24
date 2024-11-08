package com.flipfit.service;

import com.flipfit.bean.Slot;
import com.flipfit.business.SlotInterface;

import java.util.List;

public class SlotImpl implements SlotInterface {
    @Override
    public boolean addSlot(Slot slot) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Added Slot successfully");
        }
        return false;
    }

    @Override
    public boolean updateSlot(Slot slot) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Slot has been updated!");
        }
        return false;
    }

    @Override
    public boolean deleteSlot(Slot slot) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("Slot Deleted Successfully!");
        }
        return false;
    }

    @Override
    public Slot viewSlotById(int id) {
        try {

        }
        catch (Exception e) {

        }
        finally {
            System.out.println("View Slot");
        }
        return null;
    }
}
