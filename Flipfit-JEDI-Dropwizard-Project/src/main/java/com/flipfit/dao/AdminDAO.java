package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdminDAO implements AdminDAOInterface, LoginInterface, RegisterAdminInterface{
    @Override
    public String login(String username, String password) {
        try{
            Connection connection = DatabaseConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM FlipfitSchema.admin WHERE userName = ? AND password = ?");
            stmt.setString(1, username);
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
    public boolean register(String username, String password, String firstName, String lastName, String email){
        String gymId = UUID.randomUUID().toString();
        addGymManager(username,email,password,firstName,lastName,gymId);
        return true;
    }


    @Override
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM FlipfitSchema.user";

        try{
            Connection connection = DatabaseConnector.connect();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                userList.add(user);
            }
            connection.commit();
            preparedStatement.close();
        }catch(Exception e){
            System.out.println(e);
        }

        return userList;
    }

    @Override
    public void addGymManager(String userName,String email,String password,String firstName,String lastName,String gymId){
        try{
            Connection connection = DatabaseConnector.connect();
            String userId = UUID.randomUUID().toString();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO FlipfitSchema.gymManager " +
                    "(gymManagerId,userName,email,password,firstName,lastName,userId,gymId) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
            stmt.setString(7, userId);
            stmt.setString(8, gymId);
            stmt.executeQuery();
            System.out.println("New admin created with admin id: " + userId);
            connection.commit();
            stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Creating admin....");
        }
    }

    @Override
    public void addRegion(String regionName){
        try{
            Connection connection = DatabaseConnector.connect();
            String regionId = UUID.randomUUID().toString();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO FlipfitSchema.region " +
                    "(regionId,regionName) values(?,?)");
            stmt.setString(1, regionId);
            stmt.setString(2, regionName);
            stmt.executeUpdate();
            System.out.println("New region created with region id: " + regionId);
            connection.commit();
            stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Creating region....");
        }
    }

    @Override
    public void updateAdminPassword(String userName,String newPassword){
        try{
            Connection connection = DatabaseConnector.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("UPDATE FlipfitSchema.admin SET password = ? WHERE userName = ?");
            stmt.setString(1, newPassword);
            stmt.setString(2, userName);
            stmt.executeQuery();
            System.out.println("Password updated for userName: " + userName);
            connection.commit();
            stmt.close();        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println("Updating password....");
        }
    }
}
