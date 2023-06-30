package com.example.roarui;

import com.example.roarui.Component.Util.Util;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class ProfileController extends UserProfileController {

    @FXML
    protected Button highlightBut;
    protected VBox highlightBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initial(false);
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
