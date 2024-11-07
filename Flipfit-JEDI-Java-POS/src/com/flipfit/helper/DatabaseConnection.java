package com.flipfit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    public static Connection connect() throws SQLException {
        if(connection == null) {
            try {
                System.out.println("Finding class...");
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Connecting to database...");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306", "root", "password@123");
                System.out.println(con);
                System.out.println("Connected to database!");
                connection = con;
            }
            catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
        return connection;
    }
}