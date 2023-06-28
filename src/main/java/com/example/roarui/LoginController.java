package com.example.roarui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.goTo;
import static com.example.roarui.Component.Util.Util.handleCloseButton;

public class LoginController implements Initializable {


    @FXML
    private Button login_Button;

    @FXML
    private Button sighUp_Button;

    @FXML
    private TextField password_TF;

    @FXML
    private TextField userName_TF;

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }



}
