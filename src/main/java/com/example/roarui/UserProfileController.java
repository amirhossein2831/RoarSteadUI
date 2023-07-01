package com.example.roarui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;
import static com.example.roarui.Component.Util.Util.*;

public class UserProfileController extends AppController{
    @FXML
    protected AnchorPane middleAnchor;

    @FXML
    protected ImageView profImageView;

    @FXML
    protected ImageView headerImageView;

    @FXML
    protected Button followers;

    @FXML
    protected Button following;

    @FXML
    protected AnchorPane optionPane;

    @FXML
    private Button followUnFollowBut;

    @FXML
    protected Button roarBut;

    protected VBox roarBox;

    @FXML
    protected Button repliesBut;
    protected VBox repliesBox;

    @FXML
    protected Button mediaBut;
    protected VBox mediaBox;

    @FXML
    protected Button likesBut;
    protected VBox likesBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO check that person is followed or not and set textOf followUnFollowBut  following? Following : Follow
//        followUnFollowBut.setText("Follow/Following");
        initial(true);
        initialFollowUnFollowButton();
        profileBut.setOnAction(event -> goTo(event, "profile", "Profile"));
        homeBut.setOnAction(event -> goTo(event, "app", "Home"));
    }

    protected void initial(boolean isUserProf) {
        initialSevenMainButton();
        initialUpperAnchor(middleAnchor);
        logOutPageAction();
        createProfileCircle();
        //Todo should get the link from the server
        headerImageView.setOnMouseClicked(event -> openLink("/home/amirhossein/IdeaProjects/RoarSteadUI/src/main/resources/com/example/roarui/image/istockphoto-178488809-612x612.jpg"));
        profImageView.setOnMouseClicked(event -> openLink("/home/amirhossein/IdeaProjects/RoarSteadUI/src/main/resources/com/example/roarui/image/l4.png"));
        followers.setOnAction(event ->{
            isFollowers = true;
            isUserProfile = isUserProf;
            goTo(event, "followPage", "Followers");
        });
        following.setOnAction(event -> {
            isFollowers = false;
            isUserProfile = isUserProf;
            goTo(event, "followPage", "Following");
        });
        roarBut.fireEvent(syntheticMouseEvent);
    }

    protected void createProfileCircle() {
        Circle circle = new Circle(67, 67, 67);
        profImageView.setClip(circle);
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

    protected void showBox(MouseEvent event,VBox vbox) {
        if (repliesBox != null) {
            repliesBox.setVisible(false);
        }if (likesBox != null) {
            likesBox.setVisible(false);
        }if (mediaBox != null) {
            mediaBox.setVisible(false);
        }if (repliesBox != null) {
            roarBox.setVisible(false);
        }
        vbox.setVisible(true);
        roarBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        roarBut.setEffect(null);
        repliesBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        repliesBut.setEffect(null);
        mediaBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        mediaBut.setEffect(null);
        likesBut.setStyle("-fx-background-color: black;-fx-opacity: 0.5");
        likesBut.setEffect(null);


        Button selectedButton = (Button) event.getSource();
        selectedButton.setStyle("-fx-background-color: black;-fx-opacity: 1");
        selectedButton.setEffect(new Bloom(.3));
    }

    private void initialFollowUnFollowButton() {
        initialFollowingFollowersBut(followUnFollowBut);
    }
}
