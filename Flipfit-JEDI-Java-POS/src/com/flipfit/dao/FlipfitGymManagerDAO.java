package com.flipfit.dao;

import com.flipfit.bean.Gym;
import com.flipfit.bean.GymManager;
import com.flipfit.helper.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FlipfitGymManagerDAO implements FlipFitGymManagerDAOInterface {

    @Override
    public void createGymManager(GymManager gymManager) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Establish a connection to the database
            connection = DatabaseConnection.connect();

            // Step 2: Generate unique IDs for the gym manager and the user
            String gymManagerId = UUID.randomUUID().toString();  // Unique gym manager ID
            String userId = UUID.randomUUID().toString();        // Unique user ID

            // Step 3: Insert the gym manager details into the gymManager table
            stmt = connection.prepareStatement(
                    "INSERT INTO FlipfitSchema.gymManager (gymManagerId, userName, email, password, firstName, lastName, userId) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, gymManagerId);  // gymManagerId (generated UUID)
            stmt.setString(2, gymManager.userName());  // userName (inherited from Person)
            stmt.setString(3, gymManager.email());  // email (inherited from Person)
            stmt.setString(4, gymManager.password());  // password (inherited from Person)
            stmt.setString(5, gymManager.firstName());  // firstName (inherited from Person)
            stmt.setString(6, gymManager.lastName());  // lastName (inherited from Person)
            stmt.setString(7, userId);  // userId (generated UUID)

            // Step 4: Execute the query to insert the gym manager
            stmt.executeUpdate();

            // Step 5: Now insert the gyms associated with the gym manager
            Gym[] gyms = gymManager.getGyms();  // Get all gyms associated with the gym manager
            for (Gym gym : gyms) {
                // Insert each gym into the gym table, associated with the gymManagerId
                stmt = connection.prepareStatement(
                        "INSERT INTO FlipfitSchema.gym (gymId, gymManagerId, regionId, postalCode) " +
                                "VALUES (?, ?, ?, ?)"
                );
                String gymId = UUID.randomUUID().toString();  // Generate a unique gym ID
                stmt.setString(1, gymId);  // gymId
                stmt.setString(2, gymManagerId);  // gymManagerId (foreign key)
                stmt.setString(3, gym.getRegionId());  // regionId from the gym object
                stmt.setInt(4, gym.getPostalCode());  // postalCode from the gym object
                stmt.executeUpdate();
            }

            // Step 6: Commit and close resources
            connection.commit();
            stmt.close();
            connection.close();

            System.out.println("New gym manager created with GymManagerId: " + gymManagerId);

        } catch (Exception e) {
            System.out.println("Error while creating gym manager: " + e.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (Exception rollbackException) {
                System.out.println("Error during rollback: " + rollbackException.getMessage());
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception closeException) {
                System.out.println("Error closing resources: " + closeException.getMessage());
            }
        }
    }

    @Override
    public List<Gym> getOwnedGyms(String managerId) {
        List<Gym> gyms = new ArrayList<>();
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DatabaseConnection.connect();

            // Step 2: Prepare SQL query to get gyms owned by the manager
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT g.gymId, g.regionId, g.postalCode " +
                            "FROM FlipfitSchema.gym g " +
                            "JOIN FlipfitSchema.gymManager gm ON g.gymManagerId = gm.gymManagerId " +
                            "WHERE gm.gymManagerId = ?"
            );
            stmt.setString(1, managerId);  // Set managerId in the query
            ResultSet rs = stmt.executeQuery();

            // Step 3: Process the result set and map the results to Gym objects
            while (rs.next()) {
                String gymId = rs.getString("gymId");
                String regionId = rs.getString("regionId");
                int postalCode = rs.getInt("postalCode");

                // Create a Gym object for each result
                Gym gym = new Gym();
                gym.setGymId(gymId);
                gym.setRegionId(regionId);
                gym.setPinCode(postalCode);
                gyms.add(gym);
            }

            // Step 4: Close resources
            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while retrieving gyms: " + e.getMessage());
        }
        return gyms;
    }
}
