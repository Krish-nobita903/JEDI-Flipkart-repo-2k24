package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.Region;
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

            PreparedStatement stmtForSlot = connection.prepareStatement("INSERT INTO FlipfitSchema.slot (slotId,gymId,startTime,date,availableSeats, training) " +
                    "values(?,?,?,?,?,?)");

            // Bulk insert for slots
            for( Slot slot : slotsAvailable) {
                stmtForSlot.setInt(1, slot.id());
                stmtForSlot.setString(2, gymId);
                stmtForSlot.setString(3, slot.startTimeInUTC());
                stmtForSlot.setString(4, slot.date().toString());
                stmtForSlot.setInt(5, slot.availableSeats());
                stmtForSlot.setString(6, slot.training());
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
            stmtForGym.setInt(1, gym.gymId());
            stmtForGym.setString(2, gym.region().getRegionId());
            stmtForGym.setInt(3, gym.pinCode());
            stmtForGym.executeUpdate();
            stmtForGym.close();
            connection.commit();
            System.out.println("Updated gym with gym id: " + gym.gymId());
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

            PreparedStatement stmtForGym = connection.prepareStatement("SELECT * FROM FlipfitSchema.gym WHERE gymId = ?");
            stmtForGym.setString(1, gymId);
            connection.commit();
            ResultSet resultset = stmtForGym.executeQuery();

            gym.setGymId(resultset.getInt("gymId"));
            gym.setPinCode(resultset.getInt("postalCode"));

            int regionId = resultset.getInt("regionId");
            PreparedStatement stmtForRegion = connection.prepareStatement("SELECT * FROM FlipfitSchema.region WHERE regionId = ?");
            stmtForRegion.setInt(1, regionId);
            connection.commit();
            resultset = stmtForRegion.executeQuery();
            resultset.next();
            Region region = new Region();

            region.setRegionId(resultset.getString("regionId"));
            region.setRegionName(resultset.getString("regionName"));

            gym.setRegionId(region);
            System.out.println("Successfully fetched gym with gym id: " + gymId);

            stmtForGym.close();
            stmtForRegion.close();
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
            PreparedStatement stmtForGym = connection.prepareStatement("DELETE FROM FlipfitSchema.gym WHERE gymId = ?");
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

}
