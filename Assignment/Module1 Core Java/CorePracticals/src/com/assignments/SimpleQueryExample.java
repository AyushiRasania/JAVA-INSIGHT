package com.assignments;

import java.sql.*;

// 1. Write a Java program that connects to a MySQL database and executes a simple query to
//         retrieve all records from a table.
public class SimpleQueryExample {
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        String query = "SELECT * FROM employee1";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print rows
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

