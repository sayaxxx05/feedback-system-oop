package com.example.feedbacksystem;

import com.example.feedbacksystem.dao.FeedbackDAO;
import com.example.feedbacksystem.dao.FeedbackDAOImpl;
import com.example.feedbacksystem.model.Feedback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class HelloController {
    @FXML
    private TableView<Feedback> feedbackTable;

    @FXML
    private TableColumn<Feedback, Integer> feedbackIdColumn;

    @FXML
    private TableColumn<Feedback, String> contentColumn;

    @FXML
    private TableColumn<Feedback, Integer> ratingColumn;

    @FXML
    private TableColumn<Feedback, String> dateColumn;

    @FXML
    private TextField contentField;

    @FXML
    private ComboBox<String> ratingComboBox;

    private final FeedbackDAO feedbackDAO = new FeedbackDAOImpl();

    private final ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        feedbackIdColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        contentColumn.setCellValueFactory(cellData -> cellData.getValue().getContentProperty());
        ratingColumn.setCellValueFactory(cellData -> cellData.getValue().getRatingProperty().asObject());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getDateProperty().asString());

        feedbackTable.setItems(feedbackList);
        ratingComboBox.getItems().addAll("1", "2", "3", "4", "5");

        loadFeedbacks();
    }

    private void loadFeedbacks() {
        List<Feedback> feedbacks = feedbackDAO.getAllFeedback();
        feedbackList.setAll(feedbacks);
    }
}
