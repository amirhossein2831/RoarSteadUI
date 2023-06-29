package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.goTo;
import static com.example.roarui.Component.Util.Util.openLink;

public class ProfileController extends AppController {
    @FXML
    private ImageView profImageView;

    @FXML
    private ImageView headerImageView;

    @FXML
    private AnchorPane optionPane;

    @FXML
    private Button roarBut;
    private VBox roarBox;
    private boolean isRoarBoxOpen;


    @FXML
    private Button repliesBut;
    private VBox repliesBox;
    private boolean isRepliesBoxOpen;


    @FXML
    private Button highlightBut;
    private VBox highlightBox;
    private boolean isHighlightBoxOpen;

    @FXML
    private Button mediaBut;
    private VBox mediaBox;
    private boolean isMediaBoxOpen;

    @FXML
    private Button likesBut;
    private VBox likesBox;
    private boolean isLikeBOxOpen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logOutPageAction();
        createProfileCircle();
        homeBut.setOnAction(event -> goTo(event, "app", "HOME"));
        //TODO change the below link with the user link
        headerImageView.setOnMouseClicked(event -> openLink("/home/amirhossein/IdeaProjects/RoarUi/src/main/resources/com/example/roarui/image/istockphoto-178488809-612x612.jpg"));
        profImageView.setOnMouseClicked(event -> openLink("/home/amirhossein/IdeaProjects/RoarUi/src/main/resources/com/example/roarui/image/l4.png"));
    }

    private void createProfileCircle() {
        Circle circle = new Circle(67, 67, 67);
        profImageView.setClip(circle);
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

    @FXML
    void likesAction(MouseEvent event) {
        if (likesBox == null) {
            likesBox = new VBox();
            likesBox.setSpacing(10);
            likesBox.getChildren().add(new Label("likes pane"));
            likesBox.setStyle("-fx-background-color: red");
            optionPane.getChildren().add(likesBox);
            AnchorPane.setTopAnchor(likesBox, 2.0);
            AnchorPane.setLeftAnchor(likesBox, 20.0);
            AnchorPane.setBottomAnchor(likesBox, 20.0);
            AnchorPane.setRightAnchor(likesBox, 20.0);
        }
        showBox(event, likesBox);
    }

    @FXML
    void mediaAction(MouseEvent event) {
        if (mediaBox == null) {
            mediaBox = new VBox();
            mediaBox.setSpacing(10);
            mediaBox.getChildren().add(new Label("media pane"));
            mediaBox.setStyle("-fx-background-color: green");
            optionPane.getChildren().add(mediaBox);
            AnchorPane.setTopAnchor(mediaBox, 2.0);
            AnchorPane.setLeftAnchor(mediaBox, 20.0);
            AnchorPane.setBottomAnchor(mediaBox, 20.0);
            AnchorPane.setRightAnchor(mediaBox, 20.0);
        }
        showBox(event, mediaBox);
    }

    @FXML
    void repliesAction(MouseEvent event) {
        if (repliesBox == null) {
            repliesBox = new VBox();
            repliesBox.setSpacing(10);
            repliesBox.getChildren().add(new Label("replies pane"));
            repliesBox.setStyle("-fx-background-color: gray");
            optionPane.getChildren().add(repliesBox);
            AnchorPane.setTopAnchor(repliesBox, 2.0);
            AnchorPane.setLeftAnchor(repliesBox, 20.0);
            AnchorPane.setBottomAnchor(repliesBox, 20.0);
            AnchorPane.setRightAnchor(repliesBox, 20.0);
        }
        showBox(event, repliesBox);
    }

    @FXML
    void roarAction(MouseEvent event) {
        if (roarBox == null) {
            roarBox = new VBox();
            roarBox.setSpacing(10);
            roarBox.getChildren().add(new Label("roar pane"));
            roarBox.setStyle("-fx-background-color: yellow");
            optionPane.getChildren().add(roarBox);
            AnchorPane.setTopAnchor(roarBox, 2.0);
            AnchorPane.setLeftAnchor(roarBox, 20.0);
            AnchorPane.setBottomAnchor(roarBox, 20.0);
            AnchorPane.setRightAnchor(roarBox, 20.0);
        }
        showBox(event, roarBox);
    }
    private void showBox(MouseEvent event,VBox vbox) {
        if (repliesBox != null) {
            repliesBox.setVisible(false);
        }
        if (likesBox != null) {
            likesBox.setVisible(false);
        }
        if (highlightBox != null) {
            highlightBox.setVisible(false);
        }
        if (mediaBox != null) {
            mediaBox.setVisible(false);
        }
        if (repliesBox != null) {
            roarBox.setVisible(false);
        }

        // Show the selected VBox
        vbox.setVisible(true);

        // Remove underline from all buttons
        roarBut.setStyle("-fx-background-color: black;-fx-underline: false");
        repliesBut.setStyle("-fx-background-color: black;-fx-underline: false");
        mediaBut.setStyle("-fx-background-color: black;-fx-underline: false");
        highlightBut.setStyle("-fx-background-color: black;-fx-underline: false");
        likesBut.setStyle("-fx-background-color: black;-fx-underline: false");

        Button selectedButton = (Button) event.getSource();
        selectedButton.setStyle("-fx-background-color: black; -fx-underline: true;");
    }


}
