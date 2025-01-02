package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//   Identify which driver your Java program uses to connect to MySQL.
public class P03_IdentifyDriver {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "root";

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);

            // Print the driver being used
            System.out.println("Driver used: " + DriverManager.getDriver(jdbcURL).getClass().getName());

            // Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
