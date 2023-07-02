module com.example.roarui {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.validation;
    requires jdk.httpserver;
    requires java.net.http;
    requires com.google.gson;
    requires java.desktop;
//    requires jakarta.persistence;


    opens com.example.roarui to javafx.fxml;
    opens com.example.roarui.Models;


    exports com.example.roarui;
    exports com.example.roarui.Component.Annotations;
    exports com.example.roarui.Models;
    exports com.example.roarui.Component.Validation;
}