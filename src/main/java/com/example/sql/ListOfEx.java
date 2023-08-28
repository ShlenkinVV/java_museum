package com.example.sql;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ListOfEx {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Exhibit, String> cost;

    @FXML
    private TableColumn<Exhibit, String> date;

    @FXML
    private TableColumn<Exhibit, String> idEx;

    @FXML
    private TableColumn<Exhibit, String> idRes;

    @FXML
    private Button menu;

    @FXML
    private TableColumn<Exhibit, String> name;

    @FXML
    private TableColumn<Exhibit, String> num;

    @FXML
    private TableView<Exhibit> table;

    @FXML
    void initialize() {
        Database db = new Database();
        table.setItems(db.show());

        idEx.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        num.setCellValueFactory(new PropertyValueFactory<>("num"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        idRes.setCellValueFactory(new PropertyValueFactory<>("idRes"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));



        menu.setOnAction(event ->{
            Controller.openScene(menu, "main.fxml");


        } );

    }

}