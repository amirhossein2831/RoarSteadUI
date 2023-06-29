package com.example.roarui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private ImageView profImageView;
    Circle circle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createCircle();
    }

    private void createCircle() {
        circle = new Circle(75, 75, 75);
        profImageView.setClip(circle);
    }
}
