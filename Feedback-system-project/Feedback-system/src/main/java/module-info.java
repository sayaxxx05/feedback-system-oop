module com.example.feedbacksystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.feedbacksystem to javafx.fxml;
    exports com.example.feedbacksystem;
}