package com.example.demo1.Modules;

import com.example.demo1.DBConnect.DBConnectivity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class admin {
    private Connection connection;
    private int adminID;
    private String firstName;
    private String lastName;
    private String adminTitle;
    private String adminTitleNo;
    private Date DOB;
    private String gender;
    private int phoneNo;
    private String email;
    private String adresse;
    private String city;
    private String country;
    private float salary;
    private String password;

    public admin(){
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
    }
    public admin(int Admin_ID, String Admin_Title, String Admin_Title_No, String first_Name, String last_Name, Date D_O_B, String _gender, int phone_No, String _email, String _adresse, String _city, String _country , float SALARY) {
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
        adminID = Admin_ID;
        adminTitle = Admin_Title;
        adminTitleNo = Admin_Title_No;
        firstName = first_Name;
        lastName = last_Name;
        DOB = D_O_B;
        gender = _gender;
        phoneNo = phone_No;
        email = _email;
        adresse = _adresse;
        city = _city;
        country = _country;
        salary = SALARY;
    }
    public ObservableList getAdmins() {
        ObservableList<admin> data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin");
            while (resultSet.next()) {
                int id = resultSet.getInt("AdminId");
                String title = resultSet.getString("AdminTitle");
                String title_no = resultSet.getString("AdminTitle");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                Date dob = resultSet.getDate("DOB");
                String gender = resultSet.getString("gender");
                int phone = resultSet.getInt("phoneNo");
                String email = resultSet.getString("email");
                String adresse = resultSet.getString("adresse");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                float salary = resultSet.getFloat("salary");
                data.add(new admin(id, title, title_no, fname, lname, dob, gender, phone, email, adresse, city, country,salary));
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public static void main(String[] args){
        admin ne = new admin();
        ObservableList<Client> data = ne.getAdmins();
    }


}
