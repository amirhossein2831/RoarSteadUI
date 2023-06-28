module com.example.roarui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.roarui to javafx.fxml;
    exports com.example.roarui;
}