package com.example.roarui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class RoarController implements Initializable {
    @FXML
    private Button closeBut;

    @FXML
    private HBox hbox;

    @FXML
    private ImageView profView;

    @FXML
    private Button uploadFile;

    private List<Image> images = new ArrayList<>();

    private boolean backScreenDisabled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProfileCircle();
        closeBut.setOnAction(event -> closeFrontScreen());
        createImage();
    }

    public void setBackScreenDisabled(boolean disabled) {
        backScreenDisabled = disabled;
    }

    private void closeFrontScreen() {
        Stage frontStage = (Stage) closeBut.getScene().getWindow();
        frontStage.close();
        if (backScreenDisabled) {
            Stage backStage = (Stage) ((Stage) closeBut.getScene().getWindow()).getOwner();
            backStage.getScene().getRoot().setEffect(null); // Remove blur effect from back stage
            backStage.getScene().getRoot().setDisable(false);
        }
    }

    protected void createProfileCircle() {
        Circle circle = new Circle(25, 25, 25);
        profView.setClip(circle);
    }

    private void createImage() {
        hbox.setSpacing(100);
        uploadFile.setOnAction(event -> openMultiFileChooser(images,hbox));
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(200);
        anchorPane.setPrefWidth(1);
        hbox.getChildren().add(anchorPane);
    }
}
