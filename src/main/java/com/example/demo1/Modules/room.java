package com.example.demo1.Modules;

import com.example.demo1.DBConnect.DBConnectivity;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Date;

public class room{
    private Connection connection;
    private int roomNo;
    private String roomType;
    private float roomPrice;
    private int occupancy;

    public room(){
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
    }
    public room(int ROOMNO,String ROOMTYPE,float ROOMPRICE,int OCCUPANCY){
        DBConnectivity connect = new DBConnectivity();
        connection = connect.getConnection();
        this.roomNo=ROOMNO;
        this.roomType=ROOMTYPE;
        this.occupancy=OCCUPANCY;
        this.roomPrice=ROOMPRICE;
    }
    public String getroomType(){
       return  this.roomType;
    }
    public int getroomname(){
        return  this.roomNo;
    }
    public float getroomDesc(){
        return  this.roomPrice;
    }
    public ObservableList getRoom() {
        ObservableList<room> data = FXCollections.observableArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM room");
            while (resultSet.next()) {
                int roomnbr =  resultSet.getInt("roomNo");
                String roomTP = resultSet.getString("roomType");
                int OCCU = resultSet.getInt("occupancy");
                float price = resultSet.getFloat("roomPrice");
                data.add(new room(roomnbr,roomTP,price,OCCU));
            }
            return data;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
    public boolean  changeOccu(int id,int occ){
        try{
            String sql = "UPDATE room set occupancy = ? where(roomNo = ?) ";
            PreparedStatement preparedStatementt = connection.prepareStatement(sql);
            preparedStatementt.setInt(1,id);
            preparedStatementt.setInt(2,occ);
            int addr = preparedStatementt.executeUpdate();
            if(addr>0){
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
        room ne = new room();
        ObservableList<room> data = ne.getRoom();

    }

}
