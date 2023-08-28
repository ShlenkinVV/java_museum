package com.example.sql;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addnew;

    @FXML
    private Button allBut;

    @FXML
    private Button update;
    @FXML
    void initialize() {
            allBut.setOnAction(event ->{            //списко всех
                openScene(allBut, "list.fxml");
            } );

            addnew.setOnAction(event ->{            //добавить новый экспонат
                openScene(addnew, "add.fxml");
            });

            update.setOnAction(event ->{                 //обновить дату регистрации

                openScene(update, "update.fxml");

            });
    }

    public static void openScene(Button button, String window){


        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Controller.class.getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = (Parent) loader.getRoot();
        Stage stage2 = new Stage();
        stage2.setTitle("Учёт экспонатов");
        stage2.setScene(new Scene(root));
        stage2.show();
        stage2.setWidth(670);            // установка ширины
        stage2.setHeight(431);

    }
}