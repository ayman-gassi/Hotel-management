module com.example.hotelprjct {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hotelprjct to javafx.fxml;
    exports com.example.hotelprjct;
}