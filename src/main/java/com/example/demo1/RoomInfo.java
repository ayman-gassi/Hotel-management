package com.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomInfo implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    ImageView btnReturn,currentimg;
    @FXML
    Spinner<Integer> adult,children;
    @FXML
    DatePicker ArrivalDate,DepartureDate;
    @FXML
    Label loading;
    @FXML
    Button book;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diapo();
        ArrivalDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
        DepartureDate.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0 );
            }
        });

        btnReturn.setOnMouseClicked(event -> {
            Parent group = null;
            try {
                group = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(group);
            stage.setScene(scene);
            stage.setWidth(912);
            stage.setHeight(530);
            stage.show();
        });
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory.setValue(0);
        adult.setValueFactory(valueFactory);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        valueFactory2.setValue(0);
        adult.setValueFactory(valueFactory);
        children.setValueFactory(valueFactory2);

    }
    int i;

    public void diapo (){

        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("file:src/main/resources/images/rooms/room2.jpeg"));
        images.add(new Image("file:src/main/resources/images/rooms/téléchargement.jpeg"));
        images.add(new Image("file:src/main/resources/images/rooms/téléchargement (1).jpeg"));
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2),event ->{
                 loading.setVisible(false);
                currentimg.setImage(images.get(i));
                i++;
                if(i == images.size()){
                    i=0;
                }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    public void payment(ActionEvent e) throws IOException {
        Stage st = new Stage();
        st.setTitle("Payment");
        st.show();
        st.setWidth(500);
        st.setHeight(550);
        Image icon = new Image("file:src/main/resources/images/hotel.png");
        st.getIcons().add(icon);
        st.setResizable(false);
        Parent group = FXMLLoader.load(getClass().getResource("payment.fxml"));
        Scene scene = new Scene(group);
        st.setScene(scene);

    }
}
