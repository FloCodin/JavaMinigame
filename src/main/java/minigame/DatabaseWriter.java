package minigame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWriter {


    public static void insertGameResults(String playerName, int score, int rollCount) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO game_results (player_name, score, roll_count) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, playerName);
            pstmt.setInt(2, score);
            pstmt.setInt(3, rollCount);
            pstmt.executeUpdate();
            System.out.println("Game result inserted successfully for player: " + playerName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}