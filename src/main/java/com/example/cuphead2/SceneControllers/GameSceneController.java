package com.example.cuphead2.SceneControllers;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameSceneController implements Initializable {

    private final BooleanProperty wPressed = new SimpleBooleanProperty();
    private final BooleanProperty aPressed = new SimpleBooleanProperty();
    private final BooleanProperty sPressed = new SimpleBooleanProperty();
    private final BooleanProperty dPressed = new SimpleBooleanProperty();

    private final BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);

    @FXML
    private ImageView plane;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button button;

    public void start() {
        plane.setLayoutY(200);
        plane.setLayoutX(280);
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long timestamp) {

            int movementVariable = 1;
            if (wPressed.get()) {
                plane.setLayoutY(plane.getLayoutY() - movementVariable);
            }

            if (sPressed.get()) {
                plane.setLayoutY(plane.getLayoutY() + movementVariable);
            }

            if (aPressed.get()) {
                plane.setLayoutX(plane.getLayoutX() - movementVariable);
            }

            if (dPressed.get()) {
                plane.setLayoutX(plane.getLayoutX() + movementVariable);
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        movementSetup();
        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if (!aBoolean) {
                timer.start();
            } else {
                timer.stop();
            }
        }));
    }

    public void movementSetup() {
        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
                wPressed.set(true);
            }

            if (e.getCode() == KeyCode.A) {
                aPressed.set(true);
            }

            if (e.getCode() == KeyCode.S) {
                sPressed.set(true);
            }

            if (e.getCode() == KeyCode.D) {
                dPressed.set(true);
            }
        });

        pane.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.W) {
                wPressed.set(false);
            }

            if (e.getCode() == KeyCode.A) {
                aPressed.set(false);
            }

            if (e.getCode() == KeyCode.S) {
                sPressed.set(false);
            }

            if (e.getCode() == KeyCode.D) {
                dPressed.set(false);
            }
        });
    }
}



