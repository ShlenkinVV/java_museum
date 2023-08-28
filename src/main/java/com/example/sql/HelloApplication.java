package com.example.sql;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;
/**
 * Класс продукции со свойствами <b>maker</b> и <b>price</b>.
 * @autor Шленкин Владимир
 * @version 2.1
 */

public class HelloApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException, SQLException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//320x240
        stage.setTitle("Учёт экспонатов");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}