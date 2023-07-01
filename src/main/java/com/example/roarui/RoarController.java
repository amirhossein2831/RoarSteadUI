package com.example.roarui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RoarController implements Initializable {
    @FXML
    private Button closeBut;

    private boolean backScreenDisabled;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeBut.setOnAction(event -> closeFrontScreen());
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
}
