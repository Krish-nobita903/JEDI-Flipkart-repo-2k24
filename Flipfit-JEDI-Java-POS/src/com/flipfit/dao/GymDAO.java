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
        return false;
    }

    @Override
    public Gym viewGym(String gymId) {
        return null;
    }

    @Override
    public boolean deleteGym(Gym gym) {
        return false;
    }

    @Override
    public List<Gym> showAvailableSlots(String gymId){
        return null;
    }
}
