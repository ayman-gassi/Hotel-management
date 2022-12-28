package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomInfo implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    ImageView btnReturn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnReturn.setOnMouseClicked(event -> {
            Parent group = null;
            try {
                group = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(group);
            stage.setScene(scene);
            stage.setWidth(912);
            stage.setHeight(520);
            stage.show();
        });
    }

}
