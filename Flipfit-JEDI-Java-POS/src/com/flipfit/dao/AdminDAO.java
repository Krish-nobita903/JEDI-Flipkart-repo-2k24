package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminDAO implements AdminDAOInterface{
    @Override
    public boolean addGymManager(String userName,String email,String password,String firstName,String lastName){
        try{
            Connection connection = DatabaseConnection.connect();
            String gymManagerId = UUID.randomUUID().toString();
            String userId = UUID.randomUUID().toString();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO FlipfitSchema.gymManager (id,gymId,userName,email,password,firstName,lastName) values(?,?,?,?,?,?,?)");
            stmt.setString(1, gymManagerId);
            stmt.setString(2, userName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
            stmt.executeUpdate();
            System.out.println("New owner created with owner id: " + gymManagerId);
            connection.commit();
            stmt.close();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public List<User> getUserList(){
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Flipfit.user";

        try(
            Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs =  stmt.executeQuery();) {
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                users.add(user);
            }
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        return users;
    }
}
