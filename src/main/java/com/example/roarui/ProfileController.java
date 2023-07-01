package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class ProfileController extends UserProfileController {

    @FXML
    protected Button highlightBut;

    @FXML
    private Button editProfBut;

    protected VBox highlightBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        profileBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        initial(false);
        editProfBut.setOnAction(event -> openGoTo( editProfBut, "editProfile", "Edit profile"));
            try {
                setDefaultProfile(headerImageView);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    protected void setDefaultProfile(ImageView imageView) throws IOException {
        //TODO need to change on RealProfile
        if (IS_DEFAULT_IMAGE && IS_DEFAULT_IMAGE_SAVE) {
            Image imageHolder = new Image(Objects.requireNonNull(Login.class.getResource("image/defHeaderProf.png")).openStream());
            imageView.setImage(imageHolder);
        }
    }

    @FXML
    void highlightAction(MouseEvent event) {
        if (highlightBox == null) {
            highlightBox = new VBox();
            highlightBox.setSpacing(10);
            highlightBox.getChildren().add(new Label("highlight pane"));
            highlightBox.setStyle("-fx-background-color: blue");
            optionPane.getChildren().add(highlightBox);
            AnchorPane.setTopAnchor(highlightBox, 2.0);
            AnchorPane.setLeftAnchor(highlightBox, 20.0);
            AnchorPane.setBottomAnchor(highlightBox, 20.0);
            AnchorPane.setRightAnchor(highlightBox, 20.0);
        }
        showBox(event, highlightBox);
    }

    @Override
    protected void showBox(MouseEvent event,VBox vbox) {
        if (highlightBox != null) {
            highlightBox.setVisible(false);
        }
        highlightBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        highlightBut.setEffect(null);
        super.showBox(event,vbox);
    }
}
