package com.example.demo1;

import com.example.demo1.Modules.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    TextField FirstName , LastName ,TitleN , Phone,City,Country,Adress,Email,Password;
    @FXML
    ComboBox<String> Gender,TitleT;
    @FXML
    DatePicker DateP;
    @FXML
    Label alert;

    private String[] itm1={"Male","Female"};
    private String[] itm2={"CNI","Passport"};

    public void regis(ActionEvent event){
            if(FirstName.getText().isEmpty() || LastName.getText().isEmpty() || TitleN.getText().isEmpty() || Phone.getText().isEmpty() ||City.getText().isEmpty() || Country.getText().isEmpty() || Adress.getText().isEmpty() || Email.getText().isEmpty() || Password.getText().isEmpty() || Gender.getValue().isEmpty() || TitleT.getValue().isEmpty() || DateP.getValue()==null ){
                    alert.setVisible(true);
                    alert.setText("Fill All The Blanks");
            }
            else{
                Client client = new Client();
                boolean rslt = client.AddUser(FirstName.getText(),LastName.getText(),TitleT.getValue(),TitleN.getText(),Phone.getText(),DateP.getValue(),Gender.getValue(),Email.getText(),Password.getText(),Adress.getText(),City.getText(),Country.getText());
                if(rslt==true){
                    Parent group = null;
                    try {
                        group = FXMLLoader.load(getClass().getResource("login.fxml"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(group);
                    stage.setScene(scene);
                    stage.setTitle("Hotel | Login");
                    stage.setWidth(920);
                    stage.setHeight(525);
                    stage.show();
                    alert.setText("Account Created");
                    alert.setVisible(true);
                }
                else{
                    alert.setVisible(true);
                    alert.setText("Something Wrong");
                }
            }
    }
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Gender.getItems().addAll(itm1);
        TitleT.getItems().addAll(itm2);
    }
}
