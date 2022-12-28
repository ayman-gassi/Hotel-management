package com.example.demo1;

import com.example.demo1.Modules.room;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;


    @FXML
    VBox vbListRooms;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        room Room = new room();
        ObservableList<room> list = Room.getRoom();
        Node[] nodes = new Node[list.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {

                if (vbListRooms != null) {

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("ItemDesign.fxml"));
                    vbListRooms.setSpacing(15);
                    vbListRooms.getChildren().add(nodes[i]);

                } else {
                    Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}


