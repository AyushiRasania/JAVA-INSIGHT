package com.jdbc;

import java.sql.*;

// Create a stored procedure in MySQL with IN and OUT parameters (e.g., a procedure
//         that takes an employee ID as input and returns the employee's full name as output).
//         o Write a Java program that uses CallableStatement to call this stored procedure.
//         o Demonstrate how to pass IN parameters and retrieveOUT parameters.
public class P11_CallableStatementExample {
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Prepare the CallableStatement
            String procedureCall = "{CALL GetEmployeeName(?, ?)}";
            try (CallableStatement callableStatement = connection.prepareCall(procedureCall)) {

                // Set the IN parameter
                int employeeId = 1; // Example employee ID
                callableStatement.setInt(1, employeeId);

                // Register the OUT parameter
                callableStatement.registerOutParameter(2, Types.VARCHAR);

                // Execute the stored procedure
                callableStatement.execute();

                // Retrieve the OUT parameter
                String fullName = callableStatement.getString(2);
                System.out.println("Employee Full Name: " + fullName);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
