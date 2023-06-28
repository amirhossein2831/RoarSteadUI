package com.example.roarui;

import com.example.roarui.Component.Util.Util;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.goTo;

public class LoginController implements Initializable {


    @FXML
    private Button login_Button;

    @FXML
    private Button sighUp_Button;

    @FXML
    private Button exitBut;

    @FXML
    private TextField password_TF;

    @FXML
    private TextField userName_TF;

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        sighUp_Button.setOnAction(event -> goTo(event,"signUp", "SignUp"));
        exitBut.setOnAction(Util::handleCloseButton);
    }
}
