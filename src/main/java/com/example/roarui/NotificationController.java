package com.example.roarui;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.openGoTo;

public class NotificationController extends AppController{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RoarBut.setOnAction(event -> openGoTo(RoarBut, "roar", "RoarController"));
        initialSevenMainButton();
        logOutPageAction();
    }
}
