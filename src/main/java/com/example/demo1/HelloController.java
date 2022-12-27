package com.example.demo1;

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
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    private Stage stage;
    private Scene scene;

    @FXML
    VBox vbListRooms ;
    @FXML
    TextArea taRoomDetails;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] nodes = new Node[10];
        for(int i=0;i<nodes.length;i++){
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("ItemDesign.fxml"));
                vbListRooms.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

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

