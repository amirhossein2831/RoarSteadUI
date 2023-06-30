package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.goTo;


public class FollowPageController extends AppController {

    @FXML
    private Button backBut;

    @FXML
    private Button followingBut;    //followingMethod

    @FXML
    private Button followersBut; //forYouMethod

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutPageAction();
        backBut.setOnAction(event -> goTo(event, "profile", "Profile"));
    }

    @Override
    protected void underLineForYou() {
        followersBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        followingBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }
    @Override
    protected void underLineFollowing() {
        followingBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        followersBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }


}
