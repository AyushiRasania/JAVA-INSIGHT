package com.jdbc;

import java.sql.*;

public class P09_JdbcCrudExample {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Insert a record
            String insertQuery = "INSERT INTO your_table (name, age) VALUES (?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, "John Doe");
                insertStmt.setInt(2, 30);
                int rowsInserted = insertStmt.executeUpdate();
                System.out.println(rowsInserted + " record(s) inserted.");
            }

            // Update specific fields of a record
            String updateQuery = "UPDATE employee SET age = ? WHERE name = ?";
            try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                updateStmt.setInt(1, 35);
                updateStmt.setString(2, "John Doe");
                int rowsUpdated = updateStmt.executeUpdate();
                System.out.println(rowsUpdated + " record(s) updated.");
            }

            // Select records based on certain conditions
            String selectQuery = "SELECT * FROM employee WHERE age > ?";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery)) {
                selectStmt.setInt(1, 25);
                try (ResultSet resultSet = selectStmt.executeQuery()) {
                    System.out.println("Records with age > 25:");
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
                    }
                }
            }

            // Delete specific records
            String deleteQuery = "DELETE FROM employee WHERE name = ?";
            try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
                deleteStmt.setString(1, "John Doe");
                int rowsDeleted = deleteStmt.executeUpdate();
                System.out.println(rowsDeleted + " record(s) deleted.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
