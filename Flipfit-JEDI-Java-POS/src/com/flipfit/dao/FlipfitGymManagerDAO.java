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
            connection = DatabaseConnection.connect();
            String gymManagerId = UUID.randomUUID().toString();
            String userId = UUID.randomUUID().toString();

            stmt = connection.prepareStatement(
                    "INSERT INTO FlipfitSchema.gymManager (gymManagerId, userName, email, password, firstName, lastName, userId) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, gymManagerId);
            stmt.setString(2, gymManager.userName());
            stmt.setString(3, gymManager.email());
            stmt.setString(4, gymManager.password());
            stmt.setString(5, gymManager.firstName());
            stmt.setString(6, gymManager.lastName());
            stmt.setString(7, userId);

            stmt.executeUpdate();

            Gym[] gyms = gymManager.getGyms();
            for (Gym gym : gyms) {
                stmt = connection.prepareStatement(
                        "INSERT INTO FlipfitSchema.gym (gymId, gymManagerId, regionId, postalCode) " +
                                "VALUES (?, ?, ?, ?)"
                );
                String gymId = UUID.randomUUID().toString();
                stmt.setString(1, gymId);
                stmt.setString(2, gymManagerId);
                stmt.setString(3, gym.getRegionId());
                stmt.setInt(4, gym.getPostalCode());
                stmt.executeUpdate();
            }

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
    public void enrollGym(Gym gym, String managerId) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DatabaseConnection.connect();

            stmt = connection.prepareStatement(
                    "UPDATE FlipfitSchema.gym " +
                            "SET gymId = ? " +
                            "WHERE gymManagerId = ?"
            );

            stmt.setString(1, managerId);  // Set the managerId to associate with the gym
            stmt.setString(2, gym.gymId());  // The gymId to be updated

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Gym successfully enrolled and associated with the manager.");
            } else {
                System.out.println("No gym found with the provided gymId.");
            }

            connection.commit();

        } catch (Exception e) {
            System.out.println("Error while enrolling gym: " + e.getMessage());
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
            Connection connection = DatabaseConnection.connect();
            PreparedStatement stmt = connection.prepareStatement(
                    "SELECT g.gymId, g.regionId, g.postalCode " +
                            "FROM FlipfitSchema.gym g " +
                            "JOIN FlipfitSchema.gymManager gm ON g.gymId = gm.gymId " +
                            "WHERE gm.gymManagerId = ?"
            );
            stmt.setString(1, managerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String gymId = rs.getString("gymId");
                String regionId = rs.getString("regionId");
                int postalCode = rs.getInt("postalCode");

                Gym gym = new Gym();
                gym.setGymId(gymId);
                gym.setRegionId(regionId);
                gym.setPinCode(postalCode);
                gyms.add(gym);
            }

            rs.close();
            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error while retrieving gyms: " + e.getMessage());
        }
        return gyms;
    }

    @Override
    public void updateGymDetails(Gym updatedGymDetails) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DatabaseConnection.connect();

            stmt = connection.prepareStatement(
                    "UPDATE FlipfitSchema.gym " +
                            "SET regionId = ?, postalCode = ? " +
                            "WHERE gymId = ?"
            );

            stmt.setString(1, updatedGymDetails.getRegionId());
            stmt.setInt(2, updatedGymDetails.getPostalCode());
            stmt.setString(3, updatedGymDetails.gymId());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Gym details updated successfully.");
            } else {
                System.out.println("No gym found with the provided gymId.");
            }

            connection.commit();

        } catch (Exception e) {
            System.out.println("Error while updating gym details: " + e.getMessage());
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
}
