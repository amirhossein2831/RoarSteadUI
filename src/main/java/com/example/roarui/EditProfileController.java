package com.example.roarui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class EditProfileController extends ProfileController {
    @FXML
    private Button closeButton;

    @FXML
    private ImageView profileImage;

    @FXML
    private ImageView headerImage;

    @FXML
    private TextArea bioTextArea;

    @FXML
    private DatePicker birthdateField;

    @FXML
    private Button cancleImage;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button save;

    @FXML
    private Button uploadImageHeader;

    @FXML
    private Button uploadImageProfile;

    @FXML
    private TextField websiteTextField;

    private boolean backScreenDisabled;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createProfileCircle();
        uploadImageHeader.setOnAction(event -> openFileChooser(headerImage));
        uploadImageProfile.setOnAction(event -> openFileChooser(profileImage));
        //TODO should change this setDefaultProfile and handle it with DB
        try {
            super.setDefaultProfile(headerImage);
            cancleImage.setOnAction(event -> {
                try {
                    setDefaultProfile(headerImage);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TODO need to  set the text area field with the name and bio of user
        save.setOnAction(event -> save(event));
    }

    public void setBackScreenDisabled(boolean disabled) {
        backScreenDisabled = disabled;
    }
    @FXML
    private void closeFrontScreen(ActionEvent event) {
        closeDefaultHeader();
        closeFront(event);
    }

    private void closeFront(ActionEvent event) {
        Stage frontStage = (Stage) closeButton.getScene().getWindow();
        frontStage.close();
        if (backScreenDisabled) {
            Stage backStage = (Stage) ((Stage) closeButton.getScene().getWindow()).getOwner();
            backStage.getScene().getRoot().setEffect(null);
            backStage.getScene().getRoot().setDisable(false);
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLFile/profile.fxml"));
                    Parent backRoot = loader.load();
                    Scene backScene = new Scene(backRoot);
                    backStage.setScene(backScene);
                    backStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    protected void createProfileCircle() {
        Circle circle = new Circle(50, 50, 50);
        profileImage.setClip(circle);
    }

    @Override
    protected void setDefaultProfile(ImageView imageView) throws IOException {
        IS_DEFAULT_IMAGE = true;
        Image imageHolder = new Image(Objects.requireNonNull(App.class.getResource("image/defHeaderProf.png")).openStream());
        headerImage.setImage(imageHolder);
        //TODO need to change RealProfile Image
    }

    private void save(ActionEvent event) {
        if (IS_DEFAULT_IMAGE) {
            IS_DEFAULT_IMAGE_SAVE = true;
            closeFront(event);
        }
        //TODO go and save the image in date base to open them in profile and set them
    }
}
