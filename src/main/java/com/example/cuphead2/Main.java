package com.example.cuphead2;

import com.example.cuphead2.SceneControllers.MainSceneController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainSceneController sceneController = MainSceneController.get();
        stage.setTitle("CupHead");
        sceneController.LoginMenu(stage);
    }
    public static void main(String[] args) {
        launch();
    }
}