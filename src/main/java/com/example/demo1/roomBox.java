package com.example.demo1;

import com.example.demo1.Modules.room;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class roomBox implements Initializable {

    private Stage stage;
    private Scene scene;
    public static int index = 0;

    @FXML
    Button btnShow;
    @FXML
    ImageView btnReturn;
    @FXML
    TextArea taRoomDetails;
    @FXML
    Label lbRoomType,lbRoomName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        room Room = new room();
        ObservableList<room> list = Room.getRoom();
        Node[] nodes = new Node[list.size()];
        System.out.println(list);
        populateRoom(roomBox.index,list.get(roomBox.index));
        roomBox.index++;
    }

    public void populateRoom(int i,room item){
        lbRoomType.setText(item.getroomType());
        Integer no = item.getroomname();
        lbRoomName.setText(no.toString());
        taRoomDetails.setText(item.getDetails());
    }

    public void switchtoinfo(ActionEvent event){
        roomBox.index = 0;
        Parent group = null;
        try {
            group = FXMLLoader.load(getClass().getResource("roominfo.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(group);
        stage.setScene(scene);
        stage.setWidth(920);
        stage.setHeight(520);
        stage.setTitle("Hotel | BOOKING");
        stage.show();
    }

}
