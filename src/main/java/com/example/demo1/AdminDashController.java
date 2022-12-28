package com.example.demo1;

import com.example.demo1.Modules.Client;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    Button btnHome;
    @FXML
    TableView tvClients;
    @FXML
    Button btnDashboard;
    @FXML
    TableColumn<Client,Integer> id;
    @FXML
    TableColumn<Client,String> fname;
    @FXML
    TableColumn<Client,String> lname;
    @FXML
    TableColumn<Client,String> titletype;
    @FXML
    TableColumn<Client,String> titleno;
    @FXML
    TableColumn<Client,String> mail;


    public void initialize(URL url, ResourceBundle resourceBundle) {

        Client client = new Client();
        ObservableList<Client> data = client.getClientsId();

        populateClientTableView(tvClients,data);

        //EVENT HANDLERS

        btnHome.setOnMouseClicked(event -> {
            Parent group = null;
            try {
                group = FXMLLoader.load(getClass().getResource("adminH.fxml"));
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
    public void populateClientTableView(TableView tv,ObservableList<Client> data){

        tv.setItems(data);

        id.setCellValueFactory(new PropertyValueFactory<Client,Integer>("ClientID"));
        titleno.setCellValueFactory(new PropertyValueFactory<Client,String>("clientTitleNo"));
        titletype.setCellValueFactory(new PropertyValueFactory<Client,String>("clientTitle"));
        fname.setCellValueFactory(new PropertyValueFactory<Client,String>("firstName"));
        lname.setCellValueFactory(new PropertyValueFactory<Client,String>("lastName"));
        mail.setCellValueFactory(new PropertyValueFactory<Client,String>("email"));

    }
}
