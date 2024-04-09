package minigame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWriter {
    // Method to insert game results into the database
    public static void insertGameResults(String playerName, int rolls ,int score)  {
        String sql = "INSERT INTO rankings (playerName, rolls, score) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, playerName);
            pstmt.setInt(2,  rolls);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
            System.out.println("Game results inserted into the database.");
        } catch (SQLException e) {
            System.out.println("Error inserting game results: " + e.getMessage());
        }
    }
}
