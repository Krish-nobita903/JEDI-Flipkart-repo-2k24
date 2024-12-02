package com.flipfit.dao;

import com.flipfit.bean.Slot;
import com.flipfit.helper.DatabaseConnection;


import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.flipfit.helper.DatabaseConnection;

public class FlipFitSlotDAOImpl implements FlipFitSlotDAOInterface{
    @Override
    public void updateSlot(Slot prevSlot, Slot newSlot) {
        this.deleteSlot(prevSlot);
        this.addSlot(newSlot);
    }

    @Override
    public List<String> viewSlotForUser(int userId){

        // check if Query is correct as unsure of DB name and parameter name;
        List<String> slotIdList = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFitSchema.bookedSlot WHERE userId=? ");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int slotId = rs.getInt("slotId");
                String SlotId = Integer.toString(slotId);
                slotIdList.add(SlotId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotIdList;
    }
    @Override
    public void bookSlot(int userId,int slotId){
        // check if it works
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT INTO FlipFitSchema.bookedSlot (userId,slotId) WHERE (?,?) ");
            ps.setInt(1, userId);
            ps.setInt(2, slotId);
            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void cancelBookedSlotForUser(int userId, int slotId) {
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps=conn.prepareStatement("DELETE FROM FlipFitSchema.bookedSlot WHERE userId=? AND slotId=?");
            ps.setInt(1, userId);
            ps.setInt(2, slotId);
            ps.executeUpdate();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBookedSlotForUser(int userId, int slotId) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps=conn.prepareStatement("INSERT INTO FlipFitSchema.bookedSlot VALUES (?,?,)");
            ps.setInt(1, userId);
            ps.setInt(2, slotId);
            ps.executeUpdate();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSlot(Slot slot) {
        try {
            Connection conn = DatabaseConnection.connect();
            String slotId = UUID.randomUUID().toString();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO FlipFitSchema.slot (slotId, gymId, startTime, date, availableSeats, Training) VALUES (?, ?, ?, ?, ?, ?);");
            ps.setString(1, slotId);
            ps.setString(2, slot.getGymId());
            ps.setString(3, slot.getStartTimeInUTC());
            ps.setDate(4, slot.getDate());
            ps.setInt(5, slot.getAvailableSeats());
            ps.setString(6, slot.getTraining().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Slot> viewSlots() {
        List<Slot> slotList = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFitSchema.slot ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String slotId = rs.getString("slotId");

                String gymIdForSlot = rs.getString("gymId");

                String startTime = rs.getString("startTime");
                Date date = rs.getDate("date");
                int availableSeats = rs.getInt("availableSeats");
                String trainings = rs.getString("Training");
                slotList.add(new Slot(slotId, gymIdForSlot, startTime, date, availableSeats, trainings));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }
    @Override
    public List<Slot> viewSlotsForGym(int gymId) {
        List<Slot> slotList = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFitSchema.slot WHERE gymId = ?");
            ps.setInt(1, gymId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String slotId = rs.getString("slotId");

                String gymIdForSlot = rs.getString("gymId");

                String startTime = rs.getString("startTime");
                Date date = rs.getDate("date");
                int availableSeats = rs.getInt("availableSeats");
                String trainings = rs.getString("Training");
                slotList.add(new Slot(slotId, gymIdForSlot, startTime, date, availableSeats, trainings));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return slotList;
    }

    @Override
    public void deleteSlot(Slot slot) {

    }

    @Override
    public Slot getSlot(String id) {
        Slot slot = null;
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM FlipFitSchema.slot WHERE slotId = ?");
            ps.setString(1, slot.getSlotId());
            ResultSet rs = ps.executeQuery();
            String slotId = rs.getString("slotId");
            String gymId = rs.getString("gymId");
            String startTime = rs.getString("startTime");
            Date date = rs.getDate("date");
            int availableSeats = rs.getInt("availableSeats");
            String trainings = rs.getString("Training");
            slot=new Slot(slotId, gymId, startTime, date, availableSeats, trainings);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return slot;

    }
}
