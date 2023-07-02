package com.example.roarui;

import com.example.roarui.Component.Alert.Alert;
import com.example.roarui.Models.LoginForm;
import com.example.roarui.Models.User;
import com.example.roarui.Models.UserForm;
import com.google.gson.JsonObject;
import jakarta.validation.ConstraintViolation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class SignUpController implements Initializable {

    @FXML
    private TextField password;

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

    //TODO
    @FXML
    private TextField dialCode;

    //TODO
    @FXML
    private DatePicker birthDate;
    //TODO
    @FXML
    private TextField textResponse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_button.setOnAction(event -> goTo(event, "login", "Login"));
        term_button.setOnAction(event -> openLink(TERM_LINK));
        privacy_button.setOnAction(event -> openLink(PRIVACY_LINK));
        create_button.setOnAction(actionEvent -> {
            try {
                LocalDate selectedDate = birthDate.getValue();
                Date birth = Date.from(selectedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                UserForm form = new UserForm(userName.getText(), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), password.getText(), dialCode.getText(), birth);
                if (form.validate()) {
                    signUp(form, actionEvent);
                    return;
                }
                StringBuilder response = new StringBuilder();
                for (ConstraintViolation<UserForm> violation :
                        form.getViolations()) {
                    response.append(violation.getMessage() + "\n");
                    alert(response.toString());
                }
            } catch (NullPointerException e ) {
                EMPTY_FIELD.handleCustomButtonAction();
            }
        });
    }

    private void signUp(UserForm form, ActionEvent actionEvent) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(App.SIGNUP_URI))
                .POST(HttpRequest.BodyPublishers.ofString(App.gson().toJson(form)))
                .build();
        try {
            HttpResponse<String> response = App.httpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() != 200){
                alert(App.gson().fromJson(response.body(), JsonObject.class).get("message").getAsString());
                return;
            }
            alert(LoginController.login(new LoginForm(form.getUsername(), form.getPassword()), actionEvent));
        } catch (Exception e) {
            alert("Sorry there is a problem!");
            throw new RuntimeException(e);
        }
    }

    private void alert(String response) {
            Alert alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR, "Are you sure to UnFollow?",
                    ButtonType.OK);
            alert.setHeaderText("ERROR ");
            alert.setContentText(response);
            alert.handleCustomButtonAction();
        }
    }
}
