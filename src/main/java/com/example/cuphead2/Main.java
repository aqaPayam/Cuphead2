package com.example.cuphead2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainSceneController sceneController = MainSceneController.get();
        stage.setTitle("CupHead");
        sceneController.GameMenu(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}