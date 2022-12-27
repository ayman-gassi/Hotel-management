package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    private Stage stage;
    private Scene scene;


    public void switchtobooking(ActionEvent event) throws IOException {
        Parent group = FXMLLoader.load(getClass().getResource("booking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(group);
        stage.setScene(scene);
        stage.setWidth(912);
        stage.setHeight(520);
        stage.setTitle("Hotel | BOOKING");
        stage.show();

    }
    public void switchtohome(ActionEvent event) throws IOException {
        Parent group = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(group);
        stage.setScene(scene);
        stage.setWidth(912);
        stage.setHeight(520);
        stage.setTitle("Hotel | HOME");
        stage.show();
    }




}

