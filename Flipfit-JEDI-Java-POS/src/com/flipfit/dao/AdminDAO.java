package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements AdminDAOInterface, LoginInterface{

    @Override
    public String login(String adminUsername, String password){
        try{
            Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM FlipfitSchema.admin WHERE userName = ? AND password = ?");
            stmt.setString(1, adminUsername);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if( rs.next() ){
                return rs.getString("userId");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM FlipfitSchema.user";

        try(Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            while(rs.next()){
                User user = new User();
                user.setId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addGymManager(){

    }
}
