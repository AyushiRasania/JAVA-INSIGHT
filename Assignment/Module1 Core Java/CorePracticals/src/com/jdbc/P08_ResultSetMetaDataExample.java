package com.jdbc;

import java.sql.*;

// Write a program that retrieves and displays column names, types, and count of a
//         ResultSet using ResultSetMetaData.
//         o Use a SELECT query to display this metadata for a specific table.

public class P08_ResultSetMetaDataExample {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String query = "SELECT * FROM persons"; // Replace 'your_table' with the actual table name

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get column count
            int columnCount = metaData.getColumnCount();
            System.out.println("Total Columns: " + columnCount);

            // Display column names and types
            System.out.println("\nColumn Details:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                System.out.println("Column " + i + ": " + columnName + " (" + columnType + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
