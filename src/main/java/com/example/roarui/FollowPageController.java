package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    protected void underLineForYou() throws IOException {
        followersBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        followingBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }
    @Override
    protected void underLineFollowing() {
        followingBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        followersBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }

    private void createFollowersPeople() throws IOException {
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: black;");

        Button button = new Button("Following");
        button.setStyle("-fx-background-color: black;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: white;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px");
        button.setLayoutX(576);
        button.setLayoutY(13);

        Image imageHolder = new Image(Objects.requireNonNull(Login.class.getResource("image/l4.png")).openStream());
        ImageView image = new ImageView(imageHolder);
        image.setFitWidth(60);
        image.setFitHeight(60);
        image.setLayoutX(15);
        image.setLayoutY(5);
        Circle circle = new Circle(30, 30, 30);
        image.setClip(circle);

        Label profName = new Label("ProfileName");
        profName.setTextFill(Color.WHITE);

        Label userName = new Label("userName");
        Color grayColor = Color.gray(0.5);

        userName.setTextFill(grayColor);
//        profName.setStyle("-fx-text-fill: gray;" +
//                          "-fx-font-size: 14px");
//
        TextArea textArea = new TextArea("ladsjf;\nldajflasf\nsd");
        textArea.setEditable(false);
        textArea.setCursor(Cursor.NONE);
        textArea.setPrefWidth(600);
        textArea.setPrefHeight(60);
        textArea.setStyle("-fx-text-fill: white;" +
                "    -fx-font-style: italic;" +
                "    -fx-control-inner-background: black;" +
                "    -fx-background-color: black;" +
                "    -fx-border-color: black;" +
                "    -fx-border-radius: 10px;");

        AnchorPane.setTopAnchor(profName, 5.0); // Set the top anchor to 10 pixels
        AnchorPane.setLeftAnchor(profName, 80.0); // Set the left anchor to 10 pixels
        AnchorPane.setTopAnchor(userName,27.0);
        AnchorPane.setLeftAnchor(userName,82.0);
        AnchorPane.setLeftAnchor(textArea, 72.0);
        AnchorPane.setTopAnchor(textArea,49.0);
        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE,                       // Border color
                BorderStrokeStyle.SOLID,           // Border style
                CornerRadii.EMPTY,                 // Border corner radii
                new BorderWidths(1, 0, 0, 0)       // Border widths (top, right, bottom, left)
        );
        Border border = new Border(borderStroke);
        pane.getChildren().addAll(button,image,profName,userName,textArea);
        pane.setPrefHeight(70);
        pane.setBorder(border);
        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        forYouPane.getChildren().add(pane);
    }
}
