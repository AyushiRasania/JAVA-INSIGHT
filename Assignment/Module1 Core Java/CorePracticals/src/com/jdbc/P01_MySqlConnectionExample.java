package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//  Write a simple Java program to connect to a MySQL database using JDBC
public class P01_MySqlConnectionExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String jdbcURL = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "root";

        // Connection and Statement objects
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to the database successfully!");

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a SQL query
            String sqlQuery = "SELECT id, name, email FROM Users";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Step 5: Process the result set
            System.out.println("ID\tName\t\tEmail");
            System.out.println("-----------------------------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.printf("%d\t%s\t%s%n", id, name, email);
            }

            // Close the result set
            resultSet.close();

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        } finally {
            // Step 6: Close resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
