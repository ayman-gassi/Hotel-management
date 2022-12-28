package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class roomBox{

    private Stage stage;
    private Scene scene;
    @FXML
    Button btnShow;
    @FXML
    ImageView btnReturn;

    public void switchtoinfo(ActionEvent event){
        Parent group = null;
        try {
            group = FXMLLoader.load(getClass().getResource("roominfo.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(group);
        stage.setScene(scene);
        stage.setWidth(912);
        stage.setHeight(520);
        stage.setTitle("Hotel | BOOKING");
        stage.show();
    }

}
