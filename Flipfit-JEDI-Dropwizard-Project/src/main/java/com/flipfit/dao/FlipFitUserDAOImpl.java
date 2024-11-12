package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.sql.ResultSet;

public class FlipFitUserDAOImpl implements FlipFitUserDAOInterface, LoginInterface,RegisterUserInterface{


    @Override
    public boolean register(String userName, String password, String firstName, String lastName, String email, String phoneNumber, double bodyWeight){
        createUser(userName, email, password, firstName, lastName, phoneNumber, bodyWeight);
        return true;
    }

    @Override
    public String login(String username, String password){
        try{
            Connection connection = DatabaseConnector.connect();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM FlipfitSchema.user WHERE userName = ? AND password = ?");
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
    public boolean createUser(String userName, String email, String password, String firstName, String lastName, String phoneNumber,double bodyWeight) {
        try{
            Connection connection = DatabaseConnector.connect();
            String userId = UUID.randomUUID().toString();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO FlipfitSchema.user " +
                    "(userId,userName,email,password,firstName,lastName, phoneNumber, bodyWeight) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, userId);
            stmt.setString(2, userName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
            stmt.setString(7, phoneNumber);
            stmt.setDouble(8, bodyWeight);
            stmt.executeUpdate();
            System.out.println("New user created with user id: " + userId);
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
    public boolean updateUser(User user) {
        try{
            Connection connection = DatabaseConnector.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE FlipfitSchema.user SET userName = ?, email = ?, password = ?, firstName = ?, lastName = ?" +
                            ", bodyWeight = ?, phoneNumber = ? WHERE userId = ?"
            );
            stmt.setString(1, user.userName());
            stmt.setString(2, user.email());
            stmt.setString(3, user.password());
            stmt.setString(4, user.firstName());
            stmt.setString(5, user.lastName());
            stmt.setDouble(6, user.getUserWeight());
            stmt.setString(7, user.getUserPhone());
            stmt.setString(8, user.id());
            stmt.executeUpdate();
            System.out.println("Record updated for user id: "+ user.id());
            connection.commit();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    @Override
    public User getUserById(String id){
        try{
            User user = new User();
            Connection connection = DatabaseConnector.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM FlipfitSchema.user WHERE userId = ?"
            );
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if( rs.next() ){
                user.setId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserPhone(rs.getString("phoneNumber"));
                user.setUserWeight(rs.getInt("bodyWeight"));
                user.setRole("USER");
            }
            connection.commit();
            return user;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        try{
            Connection connection = DatabaseConnector.connect();
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM FlipfitSchema.user WHERE userId = ?"
            );
            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Record deleted for user id: "+ id);
            connection.commit();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePassword(String id, String password) {
        try {
            Connection conn = DatabaseConnector.connect();
            PreparedStatement ps=conn.prepareStatement("UPDATE FlipfitSchema.user SET password = ? WHERE userId = ?");
            ps.setString(1, password);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("Record updated for user id: "+ id);
            conn.commit();
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}