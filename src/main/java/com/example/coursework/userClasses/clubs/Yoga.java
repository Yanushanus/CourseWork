package com.example.coursework.userClasses.clubs;

import com.example.coursework.configs.DataBaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Yoga extends Club{
    public Yoga() throws SQLException {
    }

    @Override
    protected String setName() throws SQLException {
        String name="";
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("yoga");
        while (resultSet.next()){
            name= resultSet.getString("name");
        }
        return name;
    }

    @Override
    protected int setPrice() throws SQLException {
        int price=0;

        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("yoga");
        while (resultSet.next()){
            price= resultSet.getInt("price");
        }
        return price;
    }

    @Override
    protected String setSchedule() throws SQLException {
        String schedule="";
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("yoga");
        while (resultSet.next()){
            schedule= resultSet.getString("schedule");
        }
        return schedule;
    }

    @Override
    public String getInfo() throws SQLException {
        Yoga yoga=new Yoga();
        String info="Name of club: "+yoga.getName("yoga")+", price:"+yoga.getPrice()+",\n schedule: "+yoga.getSchedule();
        return info;
    }


}
