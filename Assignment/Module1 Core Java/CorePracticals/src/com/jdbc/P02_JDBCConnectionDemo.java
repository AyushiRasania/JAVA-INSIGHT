package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Demonstrate the process of loading a JDBC driver and establishing a connection.
public class P02_JDBCConnectionDemo {
    public static void main(String[] args) {
        // Database credentials and URL
        String jdbcURL = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "root";

        Connection connection = null;

        try {
            // Step 1: Load the JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver loaded successfully!");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database!");

        } catch (ClassNotFoundException e) {
            // Handle the case where the driver class is not found
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle database connection errors
            System.out.println("Error connecting to the database!");
            e.printStackTrace();
        } finally {
            // Step 3: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

