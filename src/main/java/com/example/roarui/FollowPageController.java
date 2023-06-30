package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.goTo;


public class FollowPageController extends AppController{

    @FXML
    private Button backBut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutPageAction();
        backBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        
    }
}
