package com.anudip.voting;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {

        try {
            // Load MySQL Driver (IMPORTANT)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/voting_db?useSSL=false&serverTimezone=UTC",
                "root",
                "security"
            );

            System.out.println("Connected successfully!");

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}