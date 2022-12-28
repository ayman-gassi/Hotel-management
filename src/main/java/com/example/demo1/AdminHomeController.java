package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    Button btnDashboard;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnDashboard.setOnMouseClicked(event -> {
            Parent group = null;
            try {
                group = FXMLLoader.load(getClass().getResource("adminD.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(group);
            stage.setScene(scene);
            stage.setWidth(912);
            stage.setHeight(520);
            stage.show();
        });
    }
}
