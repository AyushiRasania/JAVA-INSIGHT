package com.jdbc;

import java.sql.*;
import java.util.Scanner;

//  Write a Java program that performs the following CRUD operations:
//         Insert a new record.
//         Update an existing record.
//         Select and display records.
//         Delete a record from the database
public class P05_JDBC_CRUDOperation {
    //    Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Database connection established");
            while (true) {
                System.out.println("Choose an operation: ");
                System.out.println("1. Insert a new record");
                System.out.println("2. Update an existing record");
                System.out.println("3. Select and Display record");
                System.out.println("4. Delete a record");

                int choice = scanner.nextInt();
                scanner.nextLine();// Consume newline

                switch (choice) {
                    case 1:
                        insertRecord(connection, scanner);
                        break;
                    case 2:
                        updateRecord(connection, scanner);
                        break;
                    case 3:
                        selectRecord(connection);
                        break;
                    case 4:
                        deleteRecord(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Existing...!");
                    default:
                }

            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private static void insertRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Age: ");
        int age = scanner.nextInt();

        String Query = "Insert INTO persons (name,age) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            int rowInserted = preparedStatement.executeUpdate();
            System.out.println(rowInserted + " record inserted");
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }

    private static void updateRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter ID of the record to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();// consume new line
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new age: ");
        int age = scanner.nextInt();

        String query = "UPDATE persons SET name=?, age=? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setInt(3, id);
            int rowUpdated = preparedStatement.executeUpdate();
            System.out.println(rowUpdated+" row Updated ");
        }catch (SQLException e){
            System.out.println("Error Updating record: "+e.getMessage());
        }
    }

    private static void selectRecord(Connection connection) {
        String query = "SELECT * FROM persons";
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            System.out.println("ID | Name | Age ");
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println(id+" | "+name+" | "+age+" | ");
            }
        } catch (SQLException e) {
            System.out.println("Error selecting records: " + e.getMessage());
        }
    }

    private static void deleteRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter ID of the record to delete: ");
        int id =  scanner.nextInt();

        String query = "DELETE FROM persons WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            int rowDeleted = preparedStatement.executeUpdate();
            System.out.println(rowDeleted+ " record deleted");
        }catch (SQLException e){
            System.out.println("Error deleting record: "+e.getMessage());
        }
    }
}
