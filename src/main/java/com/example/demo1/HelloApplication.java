package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hotel | HOME");
        Parent group = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();
        stage.setWidth(920);
        stage.setHeight(520);
        Image icon = new Image("file:src/main/resources/images/hotel.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
}}