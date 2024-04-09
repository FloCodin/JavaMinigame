package minigame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // DB_URL is something like "jdbc:sqlite:path_to_your_db_file.db"
                String DB_URL = "localhost:5432";
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Connection to PostgreSQL has been established.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}