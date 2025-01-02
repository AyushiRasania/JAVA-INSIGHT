package com.assignment;

import java.sql.*;
import java.util.Scanner;

//1. Write a Java program that performs the following operations on a MySQL database:
//        o Insert a new record.
//        o Update an existing record.
//        o Select and display records.
//        o Delete a record.
public class CrudOperations {

    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Insert a new record");
                System.out.println("2. Update an existing record");
                System.out.println("3. Select and display records");
                System.out.println("4. Delete a record");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        insertRecord(connection, scanner);
                        break;
                    case 2:
                        updateRecord(connection, scanner);
                        break;
                    case 3:
                        selectRecords(connection);
                        break;
                    case 4:
                        deleteRecord(connection, scanner);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

            scanner.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void insertRecord(Connection connection, Scanner scanner) {
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authoName = scanner.nextLine();


        String query = "INSERT INTO book (bookName , authorName) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bookName);
            statement.setString(2, authoName);
            int rows = statement.executeUpdate();
            System.out.println(rows + " record(s) inserted.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateRecord(Connection connection, Scanner scanner) {
        System.out.print("Enter the ID of the record to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new Book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter new Author name: ");
        String authorName = scanner.nextLine();

        String query = "UPDATE book SET bookName = ?, authorName = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, bookName);
            statement.setString(2, authorName);
            statement.setInt(3, id);
            int rows = statement.executeUpdate();
            System.out.println(rows + " record(s) updated.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void selectRecords(Connection connection) {
        String query = "SELECT * FROM book";
        try (Statement statement = connection.createStatement();
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

    private static void deleteRecord(Connection connection, Scanner scanner) {
        System.out.print("Enter the ID of the record to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            System.out.println(rows + " record(s) deleted.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
