package com.example.roarui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    protected AnchorPane upperAnchor;

    @FXML
    protected AnchorPane logPane;

    @FXML
    protected AnchorPane logAnchor;

    @FXML
    private Button followingBut;

    @FXML
    protected HBox parentHbox;

    @FXML
    private Button forYouBut;

    @FXML
    protected ScrollBar scrollBar;  //connect to followers and forYou Vbox

    @FXML
    protected ScrollBar scrollBarFollowing; //connect to following vbox

    @FXML
    protected ImageView profImage;

    @FXML
    protected Button profileBut;

    @FXML
    private Button profileImageBut;

    @FXML
    protected Button exploreBut;

    @FXML
    protected Button notificationBut;

    @FXML
    protected Button messageBut;

    @FXML
    protected AnchorPane logPage;

    @FXML
    protected Button settingBut;

    protected boolean isForYou;

    protected int x;

    protected VBox forYouPane;

    protected VBox followingPane;

    private boolean isOpen;

    protected Button addAccount;

    protected Button logOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initialSevenMainButton();
        initialUpperAnchor(upperAnchor);
        logOutPageAction();
        profileImageBut.setOnAction(event -> goTo(event,"profile","Profile"));
        forYouBut.fireEvent(syntheticMouseEvent);
        scrollFollowers();
        scrollFollowing();
    }

    protected void initialSevenMainButton() {
        homeBut.setOnAction(event -> goTo(event, "app", "Home"));
        exploreBut.setOnAction(event -> goTo(event, "explore", "Explore"));
        notificationBut.setOnAction(event -> goTo(event, "notification", "Notification"));
        messageBut.setOnAction(event -> goTo(event, "message", "Messages"));
        profileBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        settingBut.setOnAction(event -> goTo(event, "setting", "Setting"));
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
    void followingOnClick(MouseEvent event) throws IOException {
        showScrollBar(scrollBarFollowing);
        if (followingPane == null) {
            followingPane = new VBox();
        }
        if (!isForYou && x != 0) {
            return;
        }
        followingPane.setStyle("-fx-background-color: red;");
        switchVbox(forYouPane,followingPane,anchorPane);
        isForYou = false;
        styleFollowingButton();
        x++;
    }// go to following part

    @FXML
    void forYouOnClick(MouseEvent event) throws IOException {
        showScrollBar(scrollBar);
        if (forYouPane == null) {
            forYouPane = new VBox();
        }
        if (isForYou) {
            return;
        }
        forYouPane.setStyle("-fx-background-color: black;");
        switchVbox(followingPane, forYouPane,anchorPane);
        styleForYouButton();
        isForYou = true;
        x++;
    }//go to For you part

    protected void styleForYouButton() throws IOException {
        forYouBut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-opacity: 1");
        forYouBut.setEffect(new Bloom(.2));
        followingBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        followingBut.setEffect(null);
    }

    protected void styleFollowingButton() throws IOException {
        followingBut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-opacity: 1");
        followingBut.setEffect(new Bloom(.2));
        forYouBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        forYouBut.setEffect(null);
    }

    protected void switchVbox(VBox oldVbox, VBox newVbox,AnchorPane pane) {
        if (containsVBox(pane)) {
            pane.getChildren().remove(oldVbox);
        }
        pane.getChildren().add(newVbox);
        AnchorPane.setTopAnchor(newVbox, 2.0);
        AnchorPane.setLeftAnchor(newVbox, 1.0);
        AnchorPane.setBottomAnchor(newVbox, 50.0);
        AnchorPane.setRightAnchor(newVbox, 1.0);
    }

    protected void initialScroll(ScrollBar scrollBar) {
        scrollBar.setMin(0);
        scrollBar.setMax(1);
        scrollBar.setUnitIncrement(20);
        scrollBar.setBlockIncrement(20);
    }

    protected void scrollFollowers() {
            initialScroll(scrollBar);
            scrollBar.valueProperty().addListener((obs, oldValue, newValue) -> {
                double scrollOffset = newValue.doubleValue() * (forYouPane.getHeight() - forYouPane.getScene().getHeight());
                forYouPane.setTranslateY(-scrollOffset);
            });
    }

    protected void scrollFollowing() {
            initialScroll(scrollBarFollowing);
            scrollBarFollowing.valueProperty().addListener((obs, oldValue, newValue) -> {
                double scrollOffset = newValue.doubleValue() * (followingPane.getHeight() - followingPane.getScene().getHeight());
                followingPane.setTranslateY(-scrollOffset);
            });
    }

    protected void showScrollBar(ScrollBar scroll) {
        scrollBar.setVisible(false);
        scrollBarFollowing.setVisible(false);
        scroll.setVisible(true);
    }

    protected void initialUpperAnchor(AnchorPane pane) {
        BorderStroke borderStroke = new BorderStroke(
                Color.WHITE,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(0, 0, 1, 0)
        );
        Border border = new Border(borderStroke);
        pane.setBorder(border);
    }

    protected void initialFollowingFollowersBut(Button button) {
        StringBuilder strButton = new StringBuilder(button.getText());
        button.setStyle("-fx-background-color: black;" +
                "-fx-background-radius: 15px;" +
                "-fx-border-color: white;" +
                "-fx-border-radius: 15px;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px");
        button.hoverProperty().addListener((observableValue, aBoolean, newValue) -> {
            if (newValue) {
                //TODO should handle that the person is followed or not
                if (strButton.toString().equals("Following")) {
                    button.setText("UnFollow");
                    button.setStyle("-fx-border-color: red;" +
                            "-fx-text-fill: red;" +
                            "-fx-background-color: black;" +
                            "-fx-background-radius: 15px;" +
                            "-fx-border-radius: 15px;" +
                            "-fx-font-size: 15px");
                } else if (strButton.toString().equals("Follow")) {
                    button.setStyle("-fx-background-color: black;" +
                            "-fx-font-weight: bold;" +
                            "-fx-background-radius: 15px;" +
                            "-fx-border-color: white;" +
                            "-fx-border-radius: 15px;" +
                            "-fx-text-fill: white;" +
                            "-fx-font-size: 15px");
                }
            } else {
                button.setText(strButton.toString());
                button.setStyle("-fx-background-color: black;" +
                        "-fx-background-radius: 15px;" +
                        "-fx-border-color: white;" +
                        "-fx-border-radius: 15px;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 15px");
            }
        });
        button.setCursor(Cursor.HAND);
        button.setOnAction(event -> {
            if (strButton.toString().equals("Following")) {
                UNFOLLOW_ALERT.handleCustomButtonAction();
                //TODO the person should be unfollowed
                if (UNFOLLOW_ALERT.isYes()) {
                    button.setText("Follow");
                    strButton.delete(0,strButton.length());
                    strButton.append("Follow");
                }
            } else if (strButton.toString().equals("Follow")) {
                //TODO the person should be followed
                button.setText("Following");
                strButton.delete(0,strButton.length());
                strButton.append("Following");
            }
        });
    }
}
