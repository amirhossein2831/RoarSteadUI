package com.example.roarui;

import com.example.roarui.Component.Alert.Alert;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class AppController implements Initializable {



    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane logPane;

    @FXML
    private Button followingBut;

    @FXML
    private Button forYouBut;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private ImageView profImage;
    private boolean isForYou;
    @FXML
    private AnchorPane logPage;

    private VBox forYouPane;

    private VBox followingPane;

    private boolean isOpen;

    private Button addAccount;

    private Button logOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       initialLogOutButton();
        profImage.setClip(new javafx.scene.shape.Circle(35, 33, 30));
        forYouBut.fireEvent(syntheticMouseEvent);
        scrollBar.setOnScroll(this::scrollDownUp);
        logOut.setOnAction(this::logOut);
        addAccount.setOnAction(event -> {});
    }

    private void initialLogOutButton() {
        logOut = new Button("Log Out");
        logOut.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-cursor: hand");
        addAccount = new Button("add an existing account");
        addAccount.setStyle("-fx-background-color: black;-fx-text-fill: white;-fx-cursor: hand");
    }
    @FXML
    private void openLogPage(MouseEvent event) {
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


    private void logOut(ActionEvent event) {
        WARNING_ALERT.handleCustomButtonAction();
        if (WARNING_ALERT.isYes()) {
            goTo(event, "login", "Login",600,450);
        }
    }

       //go to For you part

    private void switchVbox(VBox oldVbox, VBox newVbox) {
        if (containsVBox(anchorPane)) {
            anchorPane.getChildren().remove(oldVbox);
        }
        anchorPane.getChildren().add(newVbox);
        AnchorPane.setTopAnchor(newVbox, 2.0);
        AnchorPane.setLeftAnchor(newVbox, 20.0);
        AnchorPane.setBottomAnchor(newVbox, 20.0);
        AnchorPane.setRightAnchor(newVbox, 20.0);
    }


}
