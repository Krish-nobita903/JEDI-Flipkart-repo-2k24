package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO implements AdminDAOInterface{

    @Override
    public List<User> getUserList(){
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM Flipfit.users";

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
