package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Slot;
import com.flipfit.helper.DatabaseConnection;
import java.sql.Connection;
import java.util.UUID;
import java.sql.PreparedStatement;

public class GymDAO implements GymDAOInterface{
    @Override
    public boolean createGym(String regionId, int pincode, Slot[] slotsAvailable){
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);
            FlipFitSlotDAOInterface flipFitSlotDAOInterface;

            String gymId = UUID.randomUUID().toString();

            PreparedStatement stmtForGym = connection.prepareStatement("INSERT INTO FlipfitSchema.gym (id,regionId,pincode) values(?,?,?)");
            stmtForGym.setString(1, gymId);
            stmtForGym.setString(2, regionId);
            stmtForGym.setString(3, pincode);
            stmtForGym.executeUpdate();
            System.out.println("New gym created with gym id: " + userId);

            for( Slot slot : slotsAvailable) {
                flipFitSlotDAOInterface.addSlot(slot);
            }
            connection.commit();
            stmt.close();
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
            stmtForGym.setString(1, gym.getId());
            stmtForGym.setString(2, gym.getRegionId());
            stmtForGym.setString(3, gym.getPincode());
            stmtForGym.executeUpdate();

            PreparedStatement stmtForSlot = connection.prepareStatement("INSERT INTO FlipfitSchema.slot (slotId,gymId,startTime,date,availableSeats) " +
                    "values(?,?,?)");

            // Bulk insert for slots
            for( Slot slot : slotsAvailable) {
                stmtForSlot.setString(1, slot.getId());
                stmtForSlot.setString(2, gym.getId());
                stmtForSlot.setString(3, slot.getStartTime());
                stmtForSlot.setDate(4, slot.getDate());
                stmtForSlot.setInt(5, slot.getAvailableSeats());
                stmtForSlot.addBatch();
            }
            stmtForSlot.executeBatch();
            connection.commit();
            System.out.println("New gym created with gym id: " + userId);
            stmt.close();
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

            PreparedStatement stmtForGym = connection.prepareStatement("SELECT * FROM FlipfitSchema.gym WHERE gym.gymId = ?");
            stmtForGym.setString(1, gymId);
            Resultset resultset = stmtForGym.executeQuery();
            connection.commit();
            gym.setGymId(resultset.getString("gymId"));
            gym.setRegionId(resultset.getString("regionId"));
            gym.setPincode(resultset.getString("pincode"));
            System.out.println("Successfully fetched gym with gym id: " + userId);
            stmt.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return gym;
    }

    @Override
    public boolean deleteGym(Gym gym) {
        try{
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmtForGym = connection.prepareStatement("DELETE FROM FlipfitSchema.gym WHERE gym.gymId = ?");
            stmtForGym.setString(1, gymId);
            stmtForGym.executeUpdate();
            connection.commit();
            System.out.println("Successfully deleted gym with gym id: " + userId);
            stmt.close();
            connection.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Gym> showAvailableSlots(String gymId){
        return null;
    }
}
