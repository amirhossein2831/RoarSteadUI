package com.example.roarui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.goTo;

public class SignUpController implements Initializable {
    @FXML
    private TextField Password;

    @FXML
    private Button term_button;

    @FXML
    private Button privacy_button;

    @FXML
    private Button create_button;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private Button login_button;

    @FXML
    private TextField phone;

    @FXML
    private CheckBox privacy_CB;

    @FXML
    private TextField userName;

    @FXML
    private CheckBox wantNews_CB;

}
