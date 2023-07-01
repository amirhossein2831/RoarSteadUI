package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditProfileController {
    @FXML
    private Button closeButton;

    private boolean backScreenDisabled;

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
}
