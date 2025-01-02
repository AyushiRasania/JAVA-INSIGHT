package com.jdbc;

import java.sql.*;

public class P04_CRUDExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/corejava";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            // Using Statement for CRUD operations
            useStatementForCRUD(connection);

            // Using PreparedStatement for parameterized queries
            usePreparedStatementForCRUD(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void useStatementForCRUD(Connection connection) throws SQLException {
        System.out.println("\nUsing Statement for CRUD operations:");
        Statement statement = connection.createStatement();

        // Create
        String createQuery = "INSERT INTO student (id, name, email) VALUES (1, 'John Doe', 'john.doe@example.com')";
        statement.executeUpdate(createQuery);
        System.out.println("Inserted a new record using Statement.");

        // Read
        String readQuery = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(readQuery);
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Email: " + resultSet.getString("email"));
        }

        // Update
        String updateQuery = "UPDATE student SET email='john.new@example.com' WHERE id=1";
        statement.executeUpdate(updateQuery);
        System.out.println("Updated the record using Statement.");

        // Delete
        String deleteQuery = "DELETE FROM student WHERE id=1";
        statement.executeUpdate(deleteQuery);
        System.out.println("Deleted the record using Statement.");

        statement.close();
    }

    private static void usePreparedStatementForCRUD(Connection connection) throws SQLException {
        System.out.println("\nUsing PreparedStatement for parameterized queries:");

        // Create
        String createQuery = "INSERT INTO student1 (id, name, email) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Jane Doe");
            preparedStatement.setString(3, "jane.doe@example.com");
            preparedStatement.executeUpdate();
            System.out.println("Inserted a new record using PreparedStatement.");
        }

        // Read
        String readQuery = "SELECT * FROM student1 WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Email: " + resultSet.getString("email"));
            }
        }

        // Update
        String updateQuery = "UPDATE student1 SET email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, "jane.new@example.com");
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();
            System.out.println("Updated the record using PreparedStatement.");
        }

        // Delete
        String deleteQuery = "DELETE FROM student1 WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();
            System.out.println("Deleted the record using PreparedStatement.");
        }
    }
}
