package com.jdbc;

import java.sql.*;

//  Write a program that retrieves and displays metadata information about your
//         database using DatabaseMetaData.
//         o Display database name, version, list of tables, and supported SQL features.
public class P07_DatabaseMetaDataExample {
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){
            DatabaseMetaData metaData = connection.getMetaData();

//      Display Database name and version
            System.out.println("Database Product Name: "+metaData.getDatabaseProductName());
            System.out.println("Database Product Version: "+metaData.getDatabaseProductVersion());

//      List all tables in the database
            System.out.println("Tables in the database");
            try(ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"})){
                while(tables.next()){
                    String tableName = tables.getString("TABLE_NAME");
                    System.out.println("-"+tableName);
                }
            }
//          Display supported SQL features
            System.out.println("\nSupported SQL Features:");
            System.out.println("Supports Transactions: " + metaData.supportsTransactions());
            System.out.println("Supports Batch Updates: " + metaData.supportsBatchUpdates());
            System.out.println("Supports Stored Procedures: " + metaData.supportsStoredProcedures());
            System.out.println("Supports Outer Joins: " + metaData.supportsOuterJoins());
            System.out.println("Supports Full Outer Joins: " + metaData.supportsFullOuterJoins());
            System.out.println("Supports Limited Outer Joins: " + metaData.supportsLimitedOuterJoins());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
