package com.example.roarui.Component.Util;

import com.example.roarui.Component.Alert.Alert;
import com.example.roarui.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class Util {
    public static final String PRIVACY_LINK = "http://localhost:63342/Login/com/login/Privacy.html?_ijt=384tffke4ep5ncnnn3ru2hudqg&_ij_reload=RELOAD_ON_SAVE";

    public static final String TERM_LINK = "http://localhost:63342/Login/com/login/Term.html?_ijt=369bt7l5cef9tmgatlsh85u3cv&_ij_reload=RELOAD_ON_SAVE";

    public static final MouseEvent syntheticMouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
            null, 0, false, false, false, false, false, false, false, false, false, false, null);

    public static final Alert WARNING_ALERT = warningAlert();
    public static boolean isFollowers;
    public static void goTo(ActionEvent event, String path, String title) {
        Parent root = null;
        FXMLLoader load = new FXMLLoader(Login.class.getResource("FXMLFile/" + path + ".fxml"));
        try {
            root = load.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setFullScreen(false);
        stage.setScene(new Scene(root,600,450));
        stage.setTitle(title);
        stage.centerOnScreen();
        stage.show();
    }
    public static boolean containsVBox(AnchorPane anchorPane) {
        for (javafx.scene.Node node : anchorPane.getChildren()) {
            if (node instanceof VBox) {
                return true;
            }
        }
        return false;
    } //method that anchor pane has any child or not

    public static void goTo(ActionEvent event, String path, String title, int width, int height) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("FXMLFile/" + path + ".fxml"));
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, width, height));
        stage.setTitle(title);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setResizable(currentStage.isResizable());
        stage.setFullScreen(currentStage.isFullScreen());
        stage.setFullScreenExitHint(currentStage.getFullScreenExitHint());
        stage.setFullScreenExitKeyCombination(currentStage.getFullScreenExitKeyCombination());
        stage.setOpacity(currentStage.getOpacity());

        currentStage.close();
        stage.show();
    }

    public static Alert warningAlert() {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING, "Are you sure",
                ButtonType.YES, ButtonType.CLOSE);
        alert.setHeaderText("Are you sure to LOG OUT?");
        alert.setContentText("you can always back to your account !");
        return alert;
    }

    public static void handleCloseButton(ActionEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public static void handleCloseButton(MouseEvent event) {
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public static void openLink(String url) {
        try {
            String browserPath = System.getProperty("os.name").toLowerCase().contains("win") ? "cmd /c start" : "xdg-open";
            Runtime.getRuntime().exec(browserPath + " " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
