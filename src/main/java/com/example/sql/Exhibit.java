package com.example.sql;

import javafx.beans.property.StringProperty;

public class Exhibit {
    private String id;
    private String name;
    private String num;
    private String cost;
    private String date;
    private String idRes;

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String  id) {this.id= id; }
    public String getId() {  return id; }


    public void setIdRes(String idRes) { this.idRes = idRes; }
    public String getIdRes() {  return idRes;   }



    public void setName(String name) {this.name = name; }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCost() {
        return cost;
    }

    public String getDate() {
        return date;
    }



    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void show() {
        System.out.println(id + " " + name + " " + cost);
    }
}
