package minigame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Example URL for PostgreSQL JDBC
                String DB_URL = "jdbc:postgresql://localhost:5432/testdb";
                // You must replace "user" and "pass" with your actual database credentials
                String USER = "testuser";
                String PASS = "example";
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connection to PostgreSQL has been established.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}