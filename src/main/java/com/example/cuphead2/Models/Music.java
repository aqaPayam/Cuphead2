package com.example.cuphead2.Models;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Music {
    private static Music instance;

    public static Music getInstance() {
        if (instance == null)
            instance = new Music();
        return instance;
    }

    private Music() {

    }

    public void playMusic() {
        String path = "src/main/resources/com/example/cuphead2/music.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!mediaPlayer.isAutoPlay())
                    mediaPlayer.setAutoPlay(true);
            }
        }, 1000);
    }

    public void playGunMusic() {
        String path = "src/main/resources/com/example/cuphead2/gun.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mediaPlayer.pause();
            }
        }, 1000);

    }

    public void playOughtMusic() {
        String path = "src/main/resources/com/example/cuphead2/ought.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    mediaPlayer.pause();
                } catch (Exception e) {
                    System.exit(0);
                }
            }
        }, 1000);

    }
}
