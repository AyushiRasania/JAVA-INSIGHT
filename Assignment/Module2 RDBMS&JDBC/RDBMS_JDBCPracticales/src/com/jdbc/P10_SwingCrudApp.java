package com.jdbc;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

// Create a simple Swing GUI with input fields for id, fname, lname, and email.
//         o Implement CRUD operations (Insert, Update, Select, Delete) using JDBC and MySQL.
//         o On button clicks, the program should interact with the database and perform the
//         appropriate operation (insert, update, display records, or delete records).
public class P10_SwingCrudApp {
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private JFrame frame;
    private JTextField idField, fnameField, lnameField, emailField;
    private JTextArea outputArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(P10_SwingCrudApp::new);
    }

    public P10_SwingCrudApp(){
        frame = new JFrame("Swing CRUD Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("First Name:"));
        fnameField = new JTextField();
        panel.add(fnameField);

        panel.add(new JLabel("Last Name:"));
        lnameField = new JTextField();
        panel.add(lnameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton insertButton = new JButton("Insert");
        insertButton.addActionListener(e -> insertRecord());
        panel.add(insertButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateRecord());
        panel.add(updateButton);

        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(e -> selectRecords());
        panel.add(selectButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteRecord());
        panel.add(deleteButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void insertRecord() {
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String email = emailField.getText();

        String query = "INSERT INTO employee1 (fname, lname, email) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            int rows = statement.executeUpdate();
            outputArea.setText(rows + " record(s) inserted.");
        } catch (SQLException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void updateRecord() {
        String id = idField.getText();
        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String email = emailField.getText();

        String query = "UPDATE employee1 SET fname = ?, lname = ?, email = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setInt(4, Integer.parseInt(id));
            int rows = statement.executeUpdate();
            outputArea.setText(rows + " record(s) updated.");
        } catch (SQLException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void selectRecords() {
        String query = "SELECT * FROM employee1";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            StringBuilder results = new StringBuilder("ID\tFirst Name\tLast Name\tEmail\n");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String email = resultSet.getString("email");
                results.append(id).append("\t").append(fname).append("\t").append(lname).append("\t").append(email).append("\n");
            }
            outputArea.setText(results.toString());
        } catch (SQLException e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void deleteRecord() {
        String id = idField.getText();

        String query = "DELETE FROM employee1 WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(id));
            int rows = statement.executeUpdate();
            outputArea.setText(rows + " record(s) deleted.");
        } catch (SQLException e) {
            outputArea.setText("Error: " + e.getMessage());
        }

    }
}
