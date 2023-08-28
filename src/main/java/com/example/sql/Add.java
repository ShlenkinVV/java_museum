package com.example.sql;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Add {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button cancel;

    @FXML
    private TextField costid;

    @FXML
    private TextField nameid;

    @FXML
    private TextField placenum;

    @FXML
    private Label error;

    @FXML
    void initialize() {
        Database db= new Database();

        add.setOnAction(event ->{

            if (nameid.getText() == null || nameid.getText().trim().isEmpty() ||
                    costid.getText() == null ||  costid.getText().trim().isEmpty() ||
                    placenum.getText() == null || placenum.getText().trim().isEmpty()){
                    error.setStyle("-fx-text-fill: red");
                    error.setText("Ошибка, заполните все поля");
            }
            else {
                db.addEx(nameid.getText(), placenum.getText(), costid.getText());
                error.setStyle("-fx-text-fill: green");
                error.setText("Экспонат успешно добавлен");
            }
        });

        cancel.setOnAction(event ->{
            Controller.openScene(cancel, "main.fxml");

        });

    }

}