package com.example.demo1;

import com.example.demo1.DBConnect.DBConnectivity;
import com.example.demo1.Modules.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.css.StyleOrigin.USER;

public class UserAccount implements Initializable {
    @FXML
    TextField Fullname , Email  , Phone , Password , NumId , Title , Adress ,
            TitleNum  , Country , City  , Salary  ;
    @FXML
    DatePicker DOB ;
    @FXML
    private ComboBox <String> Gender;
    private String[] gender = {"Male","Female"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Fullname.setStyle("-fx-background-color: white;");
        Email.setStyle("-fx-background-color: white;");
        Gender.setStyle("-fx-background-color: white;");
        Phone.setStyle("-fx-background-color: white;");
        DOB.setStyle("-fx-background-color: white;");
        Password.setStyle("-fx-background-color: white;");
        NumId.setStyle("-fx-background-color: white;");
        Adress.setStyle("-fx-background-color: white;");
        Title.setStyle("-fx-background-color: white;");
        TitleNum.setStyle("-fx-background-color: white;");
        Country.setStyle("-fx-background-color: white;");
        City.setStyle("-fx-background-color: white;");
        Salary.setStyle("-fx-background-color: white;");

        Fullname.setEditable(false);
        Email.setEditable(false);
        Gender.setEditable(false);
        Phone.setEditable(false);
        DOB.setEditable(false);
        Password.setEditable(false);
        NumId.setEditable(false);
        Adress.setEditable(false);
        Title.setEditable(false);
        TitleNum.setEditable(false);
        Country.setEditable(false);
        City.setEditable(false);
        Salary.setEditable(false);
        //Client C1 = new Client(2,"CNI","W1ew2","SAID","DDD","www@wwww.ma");
         Client C2 = new Client();
        Fullname.setText(C2.getFirstName());
        Email.setText(C2.getEmail());
//        Gender.set(C2.getGender());
        Phone.setText(String.valueOf(C2.getPhoneNo()));
//        DOB.setTex();
        Password.setText(C2.getPwd());
        NumId.setText(String.valueOf(C2.getClientID()));
        Adress.setText(C2.getAdresse());
        Title.setText(C2.getClientTitle());
        TitleNum.setText(C2.getClientTitleNo());
        Country.setText(C2.getCountry());
        City.setText(C2.getCity());
        Salary.setText("a");





    }
    public void editall(ActionEvent e){
        Fullname.setStyle("-fx-border-color: gray;");
        Email.setStyle("-fx-border-color: gray;");
        Gender.setStyle("-fx-border-color: gray;");
        Phone.setStyle("-fx-border-color: gray;");
        DOB.setStyle("-fx-border-color: gray;");
        Password.setStyle("-fx-border-color: gray;");
        NumId.setStyle("-fx-border-color: gray;");
        Adress.setStyle("-fx-border-color: gray;");
        Title.setStyle("-fx-border-color: gray;");
        TitleNum.setStyle("-fx-border-color: gray;");
        Country.setStyle("-fx-border-color: gray;");
        City.setStyle("-fx-border-color: gray;");
        Salary.setStyle("-fx-border-color: gray;");

        Fullname.setEditable(true);
        Email.setEditable(true);
        Gender.setEditable(true);
        Phone.setEditable(true);
        Password.setEditable(true);
        NumId.setEditable(true);
        DOB.setEditable(true);
        Adress.setEditable(true);
        Title.setEditable(true);
        TitleNum.setEditable(true);
        Country.setEditable(true);
        City.setEditable(true);
        Salary.setEditable(true);
        Gender.getItems().addAll(gender);
    }
    public void Cancel(ActionEvent e)throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Page");
        alert.setHeaderText("You are exiting this page ");
        alert.setContentText("Are you sure ?!");
        if(alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("Good Bye");
            Platform.exit();
        }
    }
    public void SaveChanges(ActionEvent e){
        Fullname.setStyle("-fx-background-color: white;");
        Email.setStyle("-fx-background-color: white;");
        Gender.setStyle("-fx-background-color: white;");
        Phone.setStyle("-fx-background-color: white;");
        DOB.setStyle("-fx-background-color: white;");
        Password.setStyle("-fx-background-color: white;");
        NumId.setStyle("-fx-background-color: white;");
        Adress.setStyle("-fx-background-color: white;");
        Title.setStyle("-fx-background-color: white;");
        TitleNum.setStyle("-fx-background-color: white;");
        Country.setStyle("-fx-background-color: white;");
        City.setStyle("-fx-background-color: white;");
        Salary.setStyle("-fx-background-color: white;");



    }
}
