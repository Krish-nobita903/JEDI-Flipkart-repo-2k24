package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.sql.ResultSet;

public class UserDAO implements UserDAOInterface, LoginInterface{

    @Override
    public String login(String username, String password){
        try{
            Connection connection = DatabaseConnection.connect();
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
            Connection connection = DatabaseConnection.connect();
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
            Connection connection = DatabaseConnection.connect();
            connection.setAutoCommit(false);
            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE FlipfitSchema.user SET userName = ?, email = ?, password = ?, firstName = ?, lastName = ?" +
                            ", bodyWeight = ?, phoneNumber = ? WHERE id = ?"
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
            Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT * FROM FlipfitSchema.user WHERE id = ?"
            );
            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Record deleted for user id: "+ id);
            connection.commit();
            connection.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        try{
            Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(
                    "DELETE FROM FlipfitSchema.user WHERE id = ?"
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
            Connection conn=DatabaseConnection.connect();
            PreparedStatement ps=conn.prepareStatement("UPDATE FlipfitSchema.user SET password = ? WHERE id = ?");
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
