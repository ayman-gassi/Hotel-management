package com.example.demo1;

import com.example.demo1.Modules.Room;
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
    public static int clicked = -1;

    @FXML
    Button btnShow;
    @FXML
    ImageView btnReturn;
    @FXML
    TextArea taRoomDetails;
    @FXML
    Label lbRoomType,lbRoomName,lbId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        Room Room = new Room();
        ObservableList<com.example.demo1.Modules.Room> list = Room.getRooms();
        Node[] nodes = new Node[list.size()];
        populateRoom(roomBox.index,list.get(roomBox.index));
        roomBox.index++;
    }

    public void populateRoom(int i, Room item){
        lbRoomType.setText(item.getroomType());
        Integer no = item.getroomname();
        lbRoomName.setText(no.toString());
        taRoomDetails.setText(item.getDetails());
        lbId.setText(String.valueOf(item.getRoomNo()));
    }

    public void switchtoinfo(ActionEvent event) throws IOException{
        roomBox.clicked = Integer.valueOf(lbId.getText());
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
