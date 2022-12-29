package com.example.demo1.Modules;

import com.example.demo1.DBConnect.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;

public class Client {
    private Connection connection;
    private int ClientID;
    private String clientTitle;
    private String clientTitleNo;
    private String firstName;
    private String lastName;
    private Date DOB;
    private String gender;
    private int phoneNo;
    private String email;
    private String adresse;
    private String city;
    private String country;
    private String pwd;

    public int getClientID() {
        return ClientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public String getGender() {
        return gender;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPwd() {
        return pwd;
    }


    public Client(){
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
    }
    public Client(int Client_ID, String client_Title, String client_Title_No, String first_Name, String last_Name, Date D_O_B, String _gender, int phone_No, String _email, String _adresse, String _city, String _country,String _pwd) {
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
        ClientID = Client_ID;
        clientTitle = client_Title;
        clientTitleNo = client_Title_No;
        firstName = first_Name;
        lastName = last_Name;
        DOB = D_O_B;
        gender = _gender;
        phoneNo = phone_No;
        email = _email;
        adresse = _adresse;
        city = _city;
        country = _country;
        pwd = _pwd;
    }

    public Client(int Client_ID, String client_Title, String client_Title_No, String first_Name, String last_Name,String _email){
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
        ClientID = Client_ID;
        clientTitle = client_Title;
        clientTitleNo = client_Title_No;
        firstName = first_Name;
        lastName = last_Name;
        email = _email;
    }

    public ObservableList getClients() {
        ObservableList<Client> data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Client");
            while (resultSet.next()) {
                int id = resultSet.getInt("clientId");
                String title = resultSet.getString("clientTitle");
                String title_no = resultSet.getString("clientTitle");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                Date dob = resultSet.getDate("DOB");
                String gender = resultSet.getString("gender");
                int phone = resultSet.getInt("phoneNo");
                String email = resultSet.getString("email");
                String adresse = resultSet.getString("adresse");
                String city = resultSet.getString("city");
                String country = resultSet.getString("country");
                String pwd = resultSet.getString("pwd");
                data.add(new Client(id, title, title_no, fname, lname, dob, gender, phone, email, adresse, city, country,pwd));
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }

    public ObservableList getClientsId() {
        ObservableList<Client> data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT clientId,clientTitle,clientTitleNo,firstName,lastName,email FROM Client");
            while (resultSet.next()) {
                int id = resultSet.getInt("clientId");
                String title = resultSet.getString("clientTitle");
                String title_no = resultSet.getString("clientTitleNo");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                data.add(new Client(id, title, title_no, fname, lname, email));
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    public boolean  CheckUser(String email,String Pass){
        try{
            String sql = "SELECT * FROM client WHERE (email = ? AND pwd = ?)";
            PreparedStatement preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setString(1,email);
            preparedStatementt.setString(2,Pass);
            int addr = preparedStatementt.executeUpdate();
            if(addr > 0){
                return true;
            }
            else{
                return false;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public static void main(String[] args) {
        Client ne = new Client();
        ObservableList<Client> data = ne.getClients();
        for (Client client : data) {
            System.out.println(client.firstName);
        }
    }

    public String getClientTitle() {
        return clientTitle;
    }

    public void setClientTitle(String clientTitle) {
        this.clientTitle = clientTitle;
    }

    public String getClientTitleNo() {
        return clientTitleNo;
    }
}
