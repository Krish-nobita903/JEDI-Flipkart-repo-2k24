package com.flipfit.dao;

import com.flipfit.bean.User;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

public class UserDAO implements UserDAOInterface{
    @Override
    public boolean createUser(String userName, String email, String password, String firstName, String lastName) {
        try{
            Connection connection = DatabaseConnection.connect();
            String userId = UUID.randomUUID().toString();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO FlipfitSchema.user (id,userName,email,password,firstName,lastName) values(?,?,?,?,?,?)");
            stmt.setString(1, userId);
            stmt.setString(2, userName);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setString(5, firstName);
            stmt.setString(6, lastName);
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

            PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE FlipfitSchema.user SET userName = ?, email = ?, password = ?, firstName = ?, lastName = ? WHERE id = ?"
            );
            stmt.setString(1, user.userName());
            stmt.setString(2, user.email());
            stmt.setString(3, user.password());
            stmt.setString(4, user.firstName());
            stmt.setString(5, user.lastName());
            stmt.setString(6, user.id());
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
}
