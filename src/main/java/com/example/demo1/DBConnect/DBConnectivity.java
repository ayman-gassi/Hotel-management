package com.example.demo1.DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectivity {
    private Connection connection = null;

    public DBConnectivity(){
        try {
            String url = "jdbc:mysql://localhost:3308/hotelapp";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException ex){
            System.out.println("Error Connection : "+ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
