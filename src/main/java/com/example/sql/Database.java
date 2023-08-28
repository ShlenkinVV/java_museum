package com.example.sql;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.sql.Statement;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;


public class Database {

    Connection connection;

    {
        try {
            File file = new File("C:\\Users\\Владимир\\IdeaProjects\\SQL\\src\\main\\java\\com\\example\\sql\\connection.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String DB_USERNAME = reader.readLine();
            String DB_PASSWD = reader.readLine();
            String DB_URL = reader.readLine();

            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWD);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public int addEx(String name, String num, String cost){

        String insert = """
                INSERT INTO EXHIBIT(nam, number, cost)VALUES(?,?,?);
                 insert into restoration (dat, idrestor)
                    values ( null , null );""";

        try {
            PreparedStatement PrSt = connection.prepareStatement(insert);
            PrSt.setString(1, name);
            PrSt.setInt(2, Integer.parseInt(num.trim()));
            PrSt.setInt(3, Integer.parseInt(cost.trim()));
            PrSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }

    public void update(String day, String month, String year, String id, String idrestor){

        String upd = "update restoration set dat = '"+day+"-"+month+"-"+year+"',idrestor = ? where id = ?;";

        PreparedStatement PrSt = null;
        try {
            PrSt = connection.prepareStatement(upd);
            PrSt.setInt(1, Integer.parseInt(idrestor.trim()));
            PrSt.setInt(2, Integer.parseInt(id.trim()));

            PrSt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<Exhibit> show(){

        ObservableList<Exhibit> dat;
        dat = FXCollections.observableArrayList();

        String select = """
                select exhibit.id, exhibit.nam, exhibit.number, exhibit.cost,
                    restoration.dat, restorators.nam as namRes
                from (exhibit left join  restoration on  exhibit.id=restoration.id)
                        left join restorators on restorators.id = restoration.idrestor order by exhibit.id""";

        try {
            ResultSet rs = connection.createStatement().executeQuery(select);
            while (rs.next())
            {
                Exhibit ex = new Exhibit();
                ex.setId(rs.getString("id"));
                ex.setName(rs.getString("nam"));
                ex.setNum(rs.getString("number"));
                ex.setCost(rs.getString("cost"));
                ex.setIdRes(rs.getString("namres"));
                ex.setDate(rs.getString("dat"));

                dat.add(ex);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dat;
    }


}
