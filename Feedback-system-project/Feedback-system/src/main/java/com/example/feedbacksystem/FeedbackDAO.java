package com.example.feedbacksystem.dao;

import java.util.List;

public interface FeedbackDAO {
    void addFeedback(com.example.feedbacksystem.model.model feedback);
    List<com.example.feedbacksystem.model.model> getAllFeedback();
    void deleteFeedback(int id);
}
