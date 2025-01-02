package com.assignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

// 1. Createa Swing-based GUI with fields for id, fname, lname, and email.
// 2. Implementbuttons for Insert, Update, Select, and Delete.
// 3. Performthe corresponding JDBC operations for each button click.
class SwingClass implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1, b2, b3, b4;

    public SwingClass() {
        JFrame jFrame = new JFrame("CRUD OPERATION");
        jFrame.setVisible(true);
        jFrame.setSize(700, 500);
        jFrame.setLayout(null);

        l1 = new JLabel("Id : ");
        l1.setBounds(100, 100, 120, 20);
        jFrame.add(l1);

        l2 = new JLabel("First Name : ");
        l2.setBounds(100, 130, 120, 20);
        jFrame.add(l2);

        l3 = new JLabel("Last Name :");
        l3.setBounds(100, 160, 120, 20);
        jFrame.add(l3);

        l4 = new JLabel("Email : ");
        l4.setBounds(100, 190, 120, 20);
        jFrame.add(l4);

        t1 = new JTextField();
        t1.setBounds(220, 100, 120, 20);
        jFrame.add(t1);

        t2 = new JTextField();
        t2.setBounds(220, 130, 120, 20);
        jFrame.add(t2);

        t3 = new JTextField();
        t3.setBounds(220, 160, 120, 20);
        jFrame.add(t3);

        t4 = new JTextField();
        t4.setBounds(220, 190, 120, 20);
        jFrame.add(t4);

        b1 = new JButton("Insert");
        b1.setBounds(100, 250, 120, 20);
        jFrame.add(b1);

        b2 = new JButton("Search");
        b2.setBounds(230, 250, 120, 20);
        jFrame.add(b2);

        b3 = new JButton("Update");
        b3.setBounds(100, 280, 120, 20);
        jFrame.add(b3);

        b4 = new JButton("Delete");
        b4.setBounds(230, 280, 120, 20);
        jFrame.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/corejava", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Insert button clicked");
            int id = Integer.parseInt(t1.getText());
            String fName = t2.getText();
            String lName = t3.getText();
            String email = t4.getText();
            System.out.println("Id: " + id);
            System.out.println("First Name: " + fName);
            System.out.println("Last Name: " + lName);
            System.out.println("Email: " + email);
            try {
                Connection connection = SwingClass.createConnection();
                String URL = "Insert into developer(id,firstName,lastName,email)values(?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(URL);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, fName);
                preparedStatement.setString(3, lName);
                preparedStatement.setString(4, email);
                preparedStatement.executeUpdate();
                System.out.println("data inserted");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            System.out.println("Search button clicked");
            int id = Integer.parseInt(t1.getText());
            try {
                Connection connection = SwingClass.createConnection();
                String URL = "select * from developer where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(URL);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    t1.setText(String.valueOf(resultSet.getInt("id")));
                    t2.setText(resultSet.getString("FirstName"));
                    t3.setText(resultSet.getString("LastName"));
                    t4.setText(resultSet.getString("email"));
                } else {
                    System.out.println("data not found");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource()==b3) {
            System.out.println("Update button clicked");
            int id = Integer.parseInt(t1.getText());
            String fName = t2.getText();
            String lName = t3.getText();
            String email = t4.getText();
            try {
                Connection connection = SwingClass.createConnection();
                String URL = "select * from developer where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(URL);
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, fName);
                preparedStatement.setString(3, lName);
                preparedStatement.setString(4, email);
                preparedStatement.executeUpdate();
                System.out.println("data updated");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource()==b4) {
            System.out.println("Delete button clicked");
            int id = Integer.parseInt(t1.getText());
            try{
                Connection connection = SwingClass.createConnection();
                String URL = "select * from developer where id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(URL);
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
                System.out.println("data deleted");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

public class SwingApp {
    public static void main(String[] args) {
        new SwingClass();
    }
}
