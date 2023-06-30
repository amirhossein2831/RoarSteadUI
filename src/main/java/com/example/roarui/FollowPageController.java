package com.example.roarui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.*;


public class FollowPageController extends AppController {

    @FXML
    private Button backBut;

    @FXML
    private Button followingBut;    //followingMethod

    @FXML
    private Button followersBut; //forYouMethod

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clickOn();
        logOutPageAction();
        backBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        scrollFollowers();
        scrollFollowing();
    }
    @Override
    protected void styleForYouButton() throws IOException { //forYou is different name for followers
        isFollowers = true;
        followersBut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-opacity: 1");
        followersBut.setEffect(new Bloom(.3));
        followingBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        followingBut.setEffect(null);

        for (int i = 0; i < 12; i++) {
            //TODO it can be Follow or Following depend on that you follow or not
            createPeople("Follow",forYouPane);
        }
    }
    @Override
    protected void styleFollowingButton() throws IOException {
        isFollowers = false;
        followingBut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-opacity: 1");
        followingBut.setEffect(new Bloom(.3));
        followersBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        followersBut.setEffect(null);
        for (int i = 0; i < 20; i++) {
            createPeople("Following",followingPane);
        }
    }

    private void createPeople(String buttonText,VBox boxToAdd) throws IOException {
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: black;");
        //TODO check the person isFollowed already if yse text of button set to Following else set to Follow
        Button button = new Button(buttonText);
        String strButton = button.getText();
        button.setStyle("-fx-background-color: black;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: white;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px");
        button.hoverProperty().addListener((observableValue, aBoolean, newValue) -> {
            if (newValue) {
                //TODO should handle that the person is followed or not
                if (strButton.equals("Following")) {
                    button.setText("UnFollow");
                    button.setStyle("-fx-border-color: red;" +
                            "-fx-text-fill: red;" +
                            "-fx-background-color: black;" +
                            "-fx-background-radius: 15px;" +
                            "-fx-border-radius: 15px;" +
                            "-fx-font-size: 15px");
                } else if (strButton.equals("Follow")) {
                    button.setStyle("-fx-background-color: black;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 15px;" +
                            "-fx-border-color: white;" +
                            "-fx-border-radius: 15px;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 15px");
                }
            } else {
                button.setText(strButton);
                button.setStyle("-fx-background-color: black;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: white;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px");
            }
        });
        button.setLayoutX(576);
        button.setLayoutY(13);
        button.setCursor(Cursor.HAND);


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

        AnchorPane.setTopAnchor(profName, 5.0);
        AnchorPane.setLeftAnchor(profName, 80.0);
        AnchorPane.setTopAnchor(userName,27.0);
        AnchorPane.setLeftAnchor(userName,82.0);
        AnchorPane.setLeftAnchor(textArea, 72.0);
        AnchorPane.setTopAnchor(textArea,49.0);

        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(.5, 0, 0, 0)
        );
        Border border = new Border(borderStroke);
        setActionForProfile(image,profName,userName);
        pane.getChildren().addAll(button,image,profName,userName,textArea);
        pane.setPrefHeight(70);
        pane.setBorder(border);

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        boxToAdd.getChildren().add(pane);
    }

    private void setActionForProfile(ImageView image, Label profName, Label userName) {
        ActionEvent imageEvent = new ActionEvent(image, null);
        image.setCursor(Cursor.HAND);
        image.setOnMouseClicked(event -> goTo(imageEvent,"profile","UserProfile"));

        ActionEvent profileEvent = new ActionEvent(profName, null);
        profName.setCursor(Cursor.HAND);
        profName.setOnMouseClicked(event -> goTo(profileEvent, "profile", "Profile"));

        ActionEvent userNameAction = new ActionEvent(userName, null);
        userName.setCursor(Cursor.HAND);
        userName.setOnMouseClicked(event -> goTo(userNameAction, "profile", "Profile"));
    }

    private void clickOn(){
        if (isFollowers) {
            followersBut.fireEvent(syntheticMouseEvent);
        }
        else
            followingBut.fireEvent(syntheticMouseEvent);
    }
}
