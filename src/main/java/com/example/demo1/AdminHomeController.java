package com.example.demo1;

import com.example.demo1.Modules.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML
    ComboBox<String> choose;
    private String[] itm = {"double","simple"};
    @FXML
    TextField txtid ;
    @FXML
    TextField txtprice;
    @FXML
    Label alert;
    @FXML
    TextArea DESCRIPTION;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choose.getItems().addAll(itm);

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
    public void clear (ActionEvent e){
            txtprice.setText("");
            txtid.setText("");
            DESCRIPTION.setText("");
    }
    public void add (ActionEvent e){
        Room room = new Room();
        if(txtid.getText().isEmpty() || txtprice.getText().isEmpty() || choose.getValue().isEmpty() || DESCRIPTION.getText().isEmpty()){
                alert.setVisible(true);
                alert.setText("FILL ALL THE BLANKS");
                alert.setStyle("-fx-background-color: #FF5C5C;");
        }
        else{
            boolean rst= room.addRoom(Integer.valueOf(txtid.getText()),choose.getValue(),Float.valueOf(txtprice.getText()),DESCRIPTION.getText());
            if(rst==true){
                alert.setVisible(true);
                alert.setText("YOU ADDED A ROOM");
                alert.setStyle("-fx-background-color: #90EE90;");
                txtprice.setText("");
                txtid.setText("");
                DESCRIPTION.setText("");
            }
            else{
                alert.setVisible(true);
                alert.setText("SOMETHING WRONG TRY AGAIN");
                alert.setStyle("-fx-background-color: #FF5C5C;");
                txtprice.setText("");
                txtid.setText("");
                DESCRIPTION.setText("");
            }
        }
    }
}
