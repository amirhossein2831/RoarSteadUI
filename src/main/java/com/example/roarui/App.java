package com.example.roarui;

import com.example.roarui.Component.Validation.ExcludeStrategy;
import com.example.roarui.Models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.http.HttpClient;
import com.google.gson.*;


public class App extends Application {

    public static final String LOGIN_URI = "http://localhost:8000/user/get-token";
    public static final String APP_NAME = "Roarstead";

    private static HttpClient httpClient;
    private static Gson gson;
    private static User user;

    @Override
    public void start(Stage stage) throws IOException {
        httpClient = HttpClient.newBuilder().build();
        gson = new GsonBuilder().setExclusionStrategies(new ExcludeStrategy()).create();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("FXMLFile/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

    public static HttpClient httpClient() {
        return httpClient;
    }

    public static Gson gson(){
        return gson;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        App.user = user;
    }
}