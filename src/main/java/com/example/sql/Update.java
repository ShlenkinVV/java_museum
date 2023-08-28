package com.example.sql;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Update {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancel;

    @FXML
    private TextField day;

    @FXML
    private TextField idEx;

    @FXML
    private TextField idRes;

    @FXML
    private TextField month;

    @FXML
    private Button updatebut;

    @FXML
    private TextField year;

    @FXML
    private Label error;


    @FXML
    void initialize() {
        Database db= new Database();

        updatebut.setOnAction(event -> {
            if (    day.getText()==null || day.getText().trim().isEmpty() ||
                    month.getText()==null || month.getText().trim().isEmpty() ||
                    year.getText()==null || year.getText().trim().isEmpty() ||
                    idEx.getText()==null || idEx.getText().trim().isEmpty() ||
                    idRes.getText()==null || idRes.getText().trim().isEmpty()
                    ){
                error.setStyle("-fx-text-fill: red");
                error.setText("Ошибка, заполните все поля");
            } else {
                db.update(day.getText(), month.getText(), year.getText(), idEx.getText(), idRes.getText());
                error.setStyle("-fx-text-fill: green");
                error.setText("Дата реставрации успешно оновлена");
            }
        });

        cancel.setOnAction(event -> {
            Controller.openScene(cancel, "main.fxml");
        });
    }

}
