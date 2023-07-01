package com.example.roarui.Component.Util;

import com.example.roarui.Component.Alert.Alert;
import com.example.roarui.EditProfileController;
import com.example.roarui.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Util {
    public static final String PRIVACY_LINK = "http://localhost:63342/RoarSteadUI/src/main/resources/com/example/roarui/Html/Privacy.html?_ijt=6oqdgandgn7dahcc78lf530sd5&_ij_reload=RELOAD_ON_SAVE";

    public static final String TERM_LINK = "http://localhost:63342/RoarSteadUI/src/main/resources/com/example/roarui/Html/Term.html?_ijt=6oqdgandgn7dahcc78lf530sd5&_ij_reload=RELOAD_ON_SAVE";

    public static final MouseEvent syntheticMouseEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
            null, 0, false, false, false, false, false, false, false, false, false, false, null);

    public static final Alert WARNING_ALERT = logOutAlert();

    public static  boolean IS_DEFAULT_IMAGE;
    public static  boolean IS_DEFAULT_IMAGE_SAVE;
    public static final Alert UNFOLLOW_ALERT = unFollowAlert();
    public static boolean isFollowers;
    public static boolean isUserProfile;
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

    private static Alert logOutAlert() {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING, "Are you sure",
                ButtonType.YES, ButtonType.CLOSE);
        alert.setHeaderText("Are you sure to LOG OUT?");
        alert.setContentText("you can always back to your account !");
        return alert;
    }

    private static Alert unFollowAlert() {
        Alert alert = new Alert(javafx.scene.control.Alert.AlertType.WARNING, "Are you sure to UnFollow?",
                ButtonType.YES, ButtonType.CLOSE);
        alert.setHeaderText("Are you sure to UnFollow?");
        alert.setContentText("Their Roars will no longer show up in your home timeline." +
                " You can still view their profile, unless their Roars are protected. ");
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
    public static void openGoTo(Button openButton, String path, String title) {
        try {
                FXMLLoader loader = new FXMLLoader(Login.class.getResource("FXMLFile/" + path + ".fxml"));
            Parent frontRoot = loader.load();
            EditProfileController frontController = loader.getController();

            Stage backStage = (Stage) openButton.getScene().getWindow();
            backStage.getScene().getRoot().setEffect(new GaussianBlur(10)); // Apply blur effect to back stage

            Stage stage = new Stage();
            stage.setScene(new Scene(frontRoot));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.initOwner(openButton.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(title);
            stage.show();

            frontController.setBackScreenDisabled(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeDefaultHeader() {
        if (IS_DEFAULT_IMAGE) {
            IS_DEFAULT_IMAGE = false;
        }
    }
}
