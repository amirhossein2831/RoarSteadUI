package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.openGoTo;

public class EditProfileController extends ProfileController {
    @FXML
    private Button closeButton;

    @FXML
    private ImageView profileImage;

    private boolean backScreenDisabled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProfileCircle();
    }


    public void setBackScreenDisabled(boolean disabled) {
        backScreenDisabled = disabled;
    }
    @FXML
    private void closeFrontScreen() {
        Stage frontStage = (Stage) closeButton.getScene().getWindow();
        frontStage.close();

        if (backScreenDisabled) {
            Stage backStage = (Stage) ((Stage) closeButton.getScene().getWindow()).getOwner();
            backStage.getScene().getRoot().setEffect(null); // Remove blur effect from back stage
            backStage.getScene().getRoot().setDisable(false);
        }
    }
    @Override
    protected void createProfileCircle() {
        Circle circle = new Circle(50, 50, 50);
        profileImage.setClip(circle);
    }

}
