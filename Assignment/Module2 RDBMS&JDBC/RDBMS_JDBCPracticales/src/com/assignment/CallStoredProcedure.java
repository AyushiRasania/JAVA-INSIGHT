package com.assignment;

import java.sql.*;

public class CallStoredProcedure {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            // Step 1: Prepare the CallableStatement
            CallableStatement callableStatement = connection.prepareCall("{CALL GetEmployeeName(?, ?)}");

            // Step 2: Set the IN parameter
            int employeeId = 1; // Replace with the desired employee ID
            callableStatement.setInt(1, employeeId);

            // Step 3: Register the OUT parameter
            callableStatement.registerOutParameter(2, Types.VARCHAR);

            // Step 4: Execute the stored procedure
            callableStatement.execute();

            // Step 5: Retrieve the OUT parameter value
            String fullName = callableStatement.getString(2);
            System.out.println("Full Name of Employee with ID " + employeeId + ": " + fullName);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
