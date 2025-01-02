package com.jdbc;

import java.sql.*;

//  Write a program that executes a SELECT query and processes the ResultSet to
//         display records from the database.
//         o Demonstrate how to navigate through the ResultSet using methods like next(),
//         previous(), etc
public class P06_ResultSetNavigation {

//    database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/corejava";
    private static final String USER =  "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        String query = "SELECT * FROM persons";

        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet =  statement.executeQuery(query)){

            System.out.println("Displaying Records From the ResultSet:");

//          Navigate forward through the ResultSet
            System.out.println("Moving Forward:");
            while (resultSet.next()){
                displayRecord(resultSet);
            }

//          Navigate backward through the ResultSet
            System.out.println("Moving Backward:");
            while (resultSet.previous()){
                displayRecord(resultSet);
            }

//          Move the first record
            if (resultSet.first()){
                System.out.println("First Record");
                displayRecord(resultSet);
            }

//          Move the last record
            if (resultSet.last()){
                System.out.println("Last Record");
                displayRecord(resultSet);
            }

//          Move to an absolute position
            int position = 2;
            if (resultSet.absolute(position)){
                System.out.println("Record at position "+position+":");
                displayRecord(resultSet);
            }
        }catch (SQLException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    private static void displayRecord(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        System.out.println("ID: "+id+"Name: "+name+"age: "+age);
    }
}
