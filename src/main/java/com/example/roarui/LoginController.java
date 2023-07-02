package com.example.roarui;

import com.example.roarui.Component.Util.Util;
import com.example.roarui.Models.LoginForm;
import com.example.roarui.Models.User;
import jakarta.validation.ConstraintViolation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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

    @FXML
    private Text textResponse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sighUp_Button.setOnAction(event -> goTo(event,"signUp", "SignUp"));
        exitBut.setOnAction(Util::handleCloseButton);
        login_Button.setOnAction(actionEvent -> {
            LoginForm loginForm = new LoginForm(userName_TF.getText(), password_TF.getText());
            if(loginForm.validate()){
               login(loginForm, actionEvent);
               return;
            }
            StringBuilder response = new StringBuilder();
            for (ConstraintViolation<LoginForm> violation :
                    loginForm.getViolations()) {
                response.append(violation.getMessage() + "\n");
            }
            textResponse.setText(response.toString());
        });
    }

    private void login(LoginForm loginForm, ActionEvent actionEvent) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(App.LOGIN_URI))
                .POST(HttpRequest.BodyPublishers.ofString(App.gson().toJson(loginForm)))
                .build();

        try {
//            String jsonString = "{\"message\": {\"user\": {\"first_name\": \"Amirhossein2\", \"last_name\": \"Memool2\", \"birth_date\": \"Feb 2, 2022\", \"profile\": {\"createdAt\": \"Jul 1, 2023, 7:51:33 PM\"}, \"id\": 902, \"username\": \"amirmemool2\", \"phone\": \"09367389692\", \"email\": \"amirmemool2@gmail.com\", \"country\": {\"name\": \"Iran, Islamic Republic of Persian Gulf\", \"dial_code\": \"+98\", \"emoji\": \"🇮🇷\", \"code\": \"IR\"}}}, \"token\": \"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbWlybWVtb29sMiIsImlhdCI6MTY4ODI5NzY0MiwiZXhwIjoxNjkwODg5NjQyfQ.13olLaqVRzga0IlMN6mzx6UmX8sKlF8PQiad1PQeQ_s\"}, \"code\": 200}";
            HttpResponse<String> response = App.httpClient().send(request, HttpResponse.BodyHandlers.ofString());
            App.setUser(App.gson().fromJson(response.body(), User.class));
            goTo(actionEvent, "app", App.APP_NAME);
        } catch (Exception e) {
            textResponse.setText("Sorry there is a problem!");
            throw new RuntimeException(e);
        }
    }
}
