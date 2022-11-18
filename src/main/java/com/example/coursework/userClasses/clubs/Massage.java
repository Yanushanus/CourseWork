package com.example.coursework.userClasses.clubs;

import com.example.coursework.configs.DataBaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Massage extends Club{
    public Massage() throws SQLException {
    }

    @Override
    protected String setName() throws SQLException {
        String name="";
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("massage");
        while (resultSet.next()){
            name= resultSet.getString("name");
        }
        return name;
    }

    @Override
    protected int setPrice() throws SQLException {
        int price=0;

        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("massage");
        while (resultSet.next()){
            price= resultSet.getInt("price");
        }
        return price;
    }

    @Override
    protected String setSchedule() throws SQLException {
        String schedule="";
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        ResultSet resultSet=dataBaseHandler.getClub("massage");
        while (resultSet.next()){
            schedule= resultSet.getString("schedule");
        }
        return schedule;
    }

    @Override
    public String getInfo() throws SQLException {
        Massage massage=new Massage();
        String info="Name of club: "+massage.getName("massage")+", price:"+massage.getPrice()+",\n schedule: "+massage.getSchedule();

        return info;
    }
}


