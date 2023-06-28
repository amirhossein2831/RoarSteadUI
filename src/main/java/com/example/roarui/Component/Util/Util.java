package com.example.roarui.Component.Util;

import com.example.roarui.Component.Alert.Alert;
import com.example.roarui.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public static void openLink(String url) {
        try {
            String browserPath = System.getProperty("os.name").toLowerCase().contains("win") ? "cmd /c start" : "xdg-open";
            Runtime.getRuntime().exec(browserPath + " " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
