package com.example.demo1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserAccount implements Initializable {
    @FXML
    TextField Fullname , Email , DOB , Phone , Gender , Password , NumId , Title , Adress ,
            TitleNum  , Country , City  , Salary  ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Fullname.setEditable(false);
        Email.setEditable(false);
        DOB.setEditable(false);
        Gender.setEditable(false);
        Phone.setEditable(false);
        Password.setEditable(false);
        NumId.setEditable(false);
        Adress.setEditable(false);
        Title.setEditable(false);
        TitleNum.setEditable(false);
        Country.setEditable(false);
        City.setEditable(false);
        Salary.setEditable(false);
    }
    public void editall(ActionEvent e) {
        Fullname.setEditable(true);
        Email.setEditable(true);
        DOB.setEditable(true);
        Gender.setEditable(true);
        Phone.setEditable(true);
        Password.setEditable(true);
        NumId.setEditable(true);
        Adress.setEditable(true);
        Title.setEditable(true);
        TitleNum.setEditable(true);
        Country.setEditable(true);
        City.setEditable(true);
        Salary.setEditable(true);
        /* BD editing */
//        try{
////            ResultSet rst = stmt.executeQuery("select * from gslearning");
////            while(rst.next()){
////                System.out.println("id : "+rst.getInt("id")+" fullname : "+rst.getString("fullname")+" number : "+rst.getString("number")+" gmail : "+rst.getString("gmail")+"  rate : "+rst.getString("rate"));
//            //}
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }
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
        System.out.println("Succesfully");
//        try{
////            ResultSet rst = stmt.executeQuery("update table client set");
////            while(rst.next()){
////                System.out.println("id : "+rst.getInt("id")+" fullname : "+rst.getString("fullname")+" number : "+rst.getString("number")+" gmail : "+rst.getString("gmail")+"  rate : "+rst.getString("rate"));
//        //}
//        }catch(Exception e){
//            System.err.println(e.getMessage());
//        }

    }
}
