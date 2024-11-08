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
    public void addSlot(Slot slot) {
        try {
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO slot (slotId, gymId, startTime, date, availableSeats, Training) VALUES (?, ?, ?, ?, ?, ?);");
            ps.setInt(1, slot.getSlotId());
            ps.setInt(2, slot.getGymId());
            ps.setString(3, slot.getStartTimeInUTC());
            ps.setDate(4, (Date) slot.getDate());
            ps.setInt(5, slot.getAvailableSeats());
            ps.setString(6, slot.getTraining().toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Slot> viewSlotsForGym(int gymId) {
        List<Slot> slotList = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM slot WHERE gymId = ?");
            ps.setInt(1, gymId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int slotId = rs.getInt("slotId");

                int gymIdForSlot = rs.getInt("gymId");

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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM slot WHERE slotId = ?");
            ps.setInt(1, slot.getSlotId());
            ResultSet rs = ps.executeQuery();
            int slotId = rs.getInt("slotId");
            int gymId = rs.getInt("gymId");
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
