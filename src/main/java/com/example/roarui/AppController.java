package com.example.roarui;

import com.example.roarui.Component.Alert.Alert;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.roarui.Component.Util.Util.*;

public class AppController implements Initializable {



    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane logPane;

    @FXML
    private Button followingBut;

    @FXML
    private Button forYouBut;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private ImageView profImage;
    private boolean isForYou;
    @FXML
    private AnchorPane logPage;

    private VBox forYouPane;

    private VBox followingPane;

    private boolean isOpen;

    private Button addAccount;

    private Button logOut;

}
