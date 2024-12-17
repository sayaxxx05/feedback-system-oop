package com.example.feedbacksystem.dao;

import com.example.feedbacksystem.model.Feedback;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAOImpl implements FeedbackDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:5432/feedback_system";
    private static final String DB_USER = "User";
    private static final String DB_PASSWORD = "123456";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public void addFeedback(Feedback feedback) {
        String query = "INSERT INTO Feedbacks (user_id, category_id, content, rating, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, feedback.getUserId());
            stmt.setInt(2, feedback.getCategoryId());
            stmt.setString(3, feedback.getContent());
            stmt.setInt(4, feedback.getRating());
            stmt.setDate(5, Date.valueOf(feedback.getDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Feedback> getAllFeedback() {

    }

    @Override
    public void deleteFeedback(int id) {

    }
}
