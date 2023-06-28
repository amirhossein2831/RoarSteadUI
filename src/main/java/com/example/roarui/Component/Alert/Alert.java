package com.example.roarui.Component.Alert;

import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.util.Optional;

public class Alert extends javafx.scene.control.Alert {
    private  boolean isYes;
    private  boolean isClose;
    public Alert(AlertType alertType) {
        super(alertType);
    }


    public Alert(AlertType alertType, String s, ButtonType... buttonTypes) {
        super(alertType, s, buttonTypes);
        initStyle();
    }

    private void initStyle() {
        initStyle(StageStyle.UNDECORATED);
        initModality(Modality.APPLICATION_MODAL);
        getDialogPane().setStyle("  -fx-background-color: #f5f5f5;" +
                                "    -fx-border-color: #333;" +
                                "    -fx-border-width: 2px;" +
                                "    -fx-border-radius: 5px;" +
                                "    -fx-font-size: 14px;");
        getDialogPane().getButtonTypes().forEach(buttonType -> {
            javafx.scene.Node button = getDialogPane().lookupButton(buttonType);
            button.setStyle("-fx-background-radius: 15px");
        });
    }

    public void handleCustomButtonAction() {
        Optional<ButtonType> result = showAndWaitCustom();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            isYes = true;
            isClose = false;
        } else {
            isClose = true;
            isYes = false;
        }
    }
    public Optional<ButtonType> showAndWaitCustom() {
        return showAndWait();
    }

    public  boolean isYes() {
        return isYes;
    }

    public  boolean isClose() {
        return isClose;
    }
}
