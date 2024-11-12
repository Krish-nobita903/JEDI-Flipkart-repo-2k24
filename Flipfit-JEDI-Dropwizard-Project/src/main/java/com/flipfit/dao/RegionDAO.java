package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.User;
import com.flipfit.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionDAO implements RegionDAOInterface{

    @Override
    public List<Gym> findGyminRegion(int pinCode){
        List<Gym> gymList = new ArrayList<>();
        String sql = "SELECT * FROM FlipfitSchema.gym WHERE pinCode = ?";

        try{
            Connection connection = DatabaseConnector.connect();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,pinCode);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Gym gym = new Gym();
                gym.setGymId(rs.getString("gymId"));
                gym.setRegionId(rs.getString("regionId"));
                gymList.add(gym);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gymList;
    }
}
