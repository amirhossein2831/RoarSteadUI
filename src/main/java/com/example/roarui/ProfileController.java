package com.example.roarui;

import com.example.roarui.Component.Util.Util;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class ProfileController extends AppController {
    @FXML
    private ImageView profImageView;

    @FXML
    private ImageView headerImageView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutPageAction();
        createProfileCircle();
        homeBut.setOnAction(event -> goTo(event,"app","HOME"));
        //TODO change the below link with the user link
        headerImageView.setOnMouseClicked(event-> openLink("/home/amirhossein/IdeaProjects/RoarUi/src/main/resources/com/example/roarui/image/istockphoto-178488809-612x612.jpg"));
        profImageView.setOnMouseClicked(event -> openLink("/home/amirhossein/IdeaProjects/RoarUi/src/main/resources/com/example/roarui/image/l4.png"));
    }

    private void createProfileCircle() {
        Circle circle = new Circle(75, 75, 75);
        profImageView.setClip(circle);
    }
}
