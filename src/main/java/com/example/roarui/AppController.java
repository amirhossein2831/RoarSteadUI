package com.example.roarui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.*;

public class AppController implements Initializable {

    @FXML
    protected AnchorPane anchorPane;

    @FXML
    protected Button homeBut;

    @FXML
    protected AnchorPane logPane;

    @FXML
    protected AnchorPane logAnchor;

    @FXML
    private Button followingBut;

    @FXML
    private Button forYouBut;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    protected ImageView profImage;

    @FXML
    private Button profileBut;

    @FXML
    private Button profileImageBut;

    @FXML
    protected AnchorPane logPage;

    protected boolean isForYou;

    protected VBox forYouPane;

    protected VBox followingPane;

    private boolean isOpen;

    protected Button addAccount;

    protected Button logOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutPageAction();
        profileBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        profileImageBut.setOnAction(event -> goTo(event,"profile","Profile"));
        forYouBut.fireEvent(syntheticMouseEvent);
        scrollBar.setOnScroll(this::scrollDownUp);
    }

    protected void initialLogOutButton() {
        logOut = new Button("Log Out");
        logOut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-cursor: hand");
        addAccount = new Button("add an existing account");
        addAccount.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-cursor: hand");
    }

    protected void logOutPageAction() {
        initialLogOutButton();//
        logOut.setOnAction(this::logOut);
        profImage.setClip(new javafx.scene.shape.Circle(35, 33, 30));//
        addAccount.setOnAction(event -> {});
        logAnchor.setOnMouseClicked(this::openLogPage);
    }

    protected void openLogPage(MouseEvent event) {
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(addAccount);
        vBox.getChildren().add(logOut);
        if (isOpen) {
            isOpen = false;
            logPane.getChildren().remove(logPage);
            return;
        }
        logPage = new AnchorPane();
        logPage.setStyle("-fx-background-color: black;-fx-background-radius: 20px;");
        logPage.setLayoutX(335);
        logPage.setLayoutY(880);
        logPage.getChildren().add(vBox);
        logPane.getChildren().add(logPage);

        AnchorPane.setTopAnchor(vBox, 5.0);
        AnchorPane.setLeftAnchor(vBox, 5.0);
        AnchorPane.setBottomAnchor(vBox, 5.0);
        AnchorPane.setRightAnchor(vBox, 5.0);
        isOpen = true;
    }//open and close a page to log out and go to existing account

    protected void logOut(ActionEvent event) {
        WARNING_ALERT.handleCustomButtonAction();
        if (WARNING_ALERT.isYes()) {
            goTo(event, "login", "Login",600,450);
        }
    }

    @FXML
    void followingOnClick(MouseEvent event) {
        if (followingPane == null) {
            followingPane = new VBox();
        }
        if (!isForYou) {
            return;
        }
        followingPane.setStyle("-fx-background-color: red;");
        switchVbox(forYouPane,followingPane,anchorPane);
        isForYou = false;
        underLineFollowing();
    }// go to following part

    @FXML
    void forYouOnClick(MouseEvent event) throws IOException {
        if (forYouPane == null) {
            forYouPane = new VBox();
        }
        if (isForYou) {
            return;
        }
        forYouPane.setStyle("-fx-background-color: green;");
        switchVbox(followingPane, forYouPane,anchorPane);
        underLineForYou();
        isForYou = true;
    }//go to For you part

    protected void underLineForYou() throws IOException {
        forYouBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        followingBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }
    protected void underLineFollowing() {
        followingBut.setStyle("-fx-underline: true;-fx-background-color: black;-fx-text-fill: white");
        forYouBut.setStyle("-fx-underline: false;-fx-background-color: black");
    }

    protected void switchVbox(VBox oldVbox, VBox newVbox,AnchorPane pane) {
        if (containsVBox(pane)) {
            pane.getChildren().remove(oldVbox);
        }
        pane.getChildren().add(newVbox);
        AnchorPane.setTopAnchor(newVbox, 2.0);
        AnchorPane.setLeftAnchor(newVbox, 1.0);
        AnchorPane.setBottomAnchor(newVbox, 1.0);
        AnchorPane.setRightAnchor(newVbox, 1.0);
    }

    private void scrollDownUp(ScrollEvent event) {
        scrollBar.setValue(scrollBar.getValue() + event.getDeltaX());
        scrollBar.valueProperty().addListener((observable, oldValue, newValue) ->
                {   if (isForYou)
                    forYouPane.setLayoutX(-newValue.doubleValue());
                else
                    followingPane.setLayoutX(-newValue.doubleValue());
                }
        );
    }       //use to connect the scroll to vbox in forYou and following

}
