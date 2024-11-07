package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.helper.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.util.List;

public class GymDAO implements GymDAOInterface{
    @Override
    public boolean createGym(String regionId, int pincode, Slot[] slotsAvailable){
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);
            String gymId = UUID.randomUUID().toString();

            PreparedStatement stmtForGym = connection.prepareStatement("INSERT INTO FlipfitSchema.gym (id,regionId,pincode) values(?,?,?)");
            stmtForGym.setString(1, gymId);
            stmtForGym.setString(2, regionId);
            stmtForGym.setInt(3, pincode);
            stmtForGym.executeUpdate();

            stmtForGym.close();

            PreparedStatement stmtForSlot = connection.prepareStatement("INSERT INTO FlipfitSchema.slot (slotId,gymId,startTime,date,availableSeats) " +
                    "values(?,?,?,?,?)");

            // Bulk insert for slots
            for( Slot slot : slotsAvailable) {
                stmtForSlot.setString(1, slot.id());
                stmtForSlot.setString(2, gymId);
                stmtForSlot.setString(3, slot.startTimeInUTC());
                stmtForSlot.setDate(4, slot.date());
                stmtForSlot.setInt(5, slot.availableSlots());
                stmtForSlot.addBatch();
            }
            stmtForSlot.executeBatch();

            System.out.println("New gym created with gym id: " + gymId);
            connection.commit();
            stmtForSlot.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGym(Gym gym) {
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);

            PreparedStatement stmtForGym = connection.prepareStatement("INSERT INTO FlipfitSchema.gym (id,regionId,pincode) values(?,?,?)");
            stmtForGym.setString(1, gym.gymId());
            stmtForGym.setString(2, gym.region());
            stmtForGym.setInt(3, gym.pincode());
            stmtForGym.executeUpdate();
            stmtForGym.close();

            PreparedStatement stmtForSlot = connection.prepareStatement("INSERT INTO FlipfitSchema.slot (slotId,gymId,startTime,date,availableSeats) " +
                    "values(?,?,?,?,?)");

            // Bulk insert for slots
            for( Slot slot : slotsAvailable) {
                stmtForSlot.setString(1, slot.id());
                stmtForSlot.setString(2, gym.gymId());
                stmtForSlot.setString(3, slot.startTimeInUTC());
                stmtForSlot.setDate(4, slot.date());
                stmtForSlot.setInt(5, slot.availableSlots());
                stmtForSlot.addBatch();
            }
            stmtForSlot.executeBatch();

            connection.commit();
            System.out.println("Updated gym with gym id: " + gym.getId());
            stmtForSlot.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Gym viewGym(String gymId) {
        Gym gym = null;
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);

            PreparedStatement stmtForGym = connection.prepareStatement("SELECT * FROM FlipfitSchema.gym AS gym WHERE gym.gymId = ?");
            stmtForGym.setString(1, gymId);
            ResultSet resultset = stmtForGym.executeQuery();
            connection.commit();
            resultset.next();
            gym.setGymId(resultset.getString("gymId"));
            gym.setRegionId(resultset.getString("regionId"));
            gym.setPincode(resultset.getInt("postalCode"));
            System.out.println("Successfully fetched gym with gym id: " + gymId);
            stmtForGym.close();
            resultset.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return gym;
    }

    @Override
    public boolean deleteGym(String gymId) {
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmtForGym = connection.prepareStatement("DELETE FROM FlipfitSchema.gym AS gym WHERE gym.gymId = ?");
            stmtForGym.setString(1, gymId);
            stmtForGym.executeUpdate();
            connection.commit();
            System.out.println("Successfully deleted gym with gym id: " + gymId);
            stmtForGym.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Slot> showAvailableSlots(String gymId){
        List<Slot> slots = new ArrayList<Slot>();
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);

            PreparedStatement stmtForSlots = connection.prepareStatement("SELECT * FROM FlipfitSchema.slot AS slot WHERE slot.gymId = ?");
            stmtForSlots.setString(1, gymId);
            ResultSet resultset = stmtForSlots.executeQuery();
            connection.commit();
            while(resultset.next()){
                Slot slot = new Slot();
                slot.setSlotId(resultset.getString("slotId"));
                slot.setGymId(resultset.getString("gymId"));
                slot.startTimeInUTC(resultset.String("startTime"));
                slot.setDate(resultset.getDate("date"));
                slot.setAvailableSeats(resultset.getInt("availableSeats"));
                slots.add(slot);
            }
            System.out.println("Successfully fetched "+ slots.size() +" slots with gym id: " + gymId);
            stmtForSlots.close();
            resultset.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return slots;
    }
}
