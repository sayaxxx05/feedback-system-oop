package com.example.feedbacksystem.model;

import java.time.LocalDate;

public class Feedback {
    private int id;
    private int userId;
    private int categoryId;
    private String content;
    private int rating;
    private LocalDate date;

    public Feedback(int id, int userId, int categoryId, String content, int rating, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.categoryId = categoryId;
        this.content = content;
        this.rating = rating;
        this.date = date;
    }

    // Getters and setters here...
}
