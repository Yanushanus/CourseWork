package com.example.coursework.userClasses.clubs;

import java.sql.SQLException;
import java.util.Objects;

public abstract class Club {
    protected final String name;
    private final int price;
    private final String schedule;

    protected Club() throws SQLException {
       name=setName();
       price=setPrice();
       schedule=setSchedule();
    }
    protected abstract String setName() throws SQLException;
    protected abstract int setPrice() throws SQLException;
    protected abstract String setSchedule() throws SQLException;
    public String getName(String name) {
        return name;
    }
    public String getName(){return name;}

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Club)) return false;
        Club club = (Club) o;
        return price == club.price && Objects.equals(name, club.name) && Objects.equals(schedule, club.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, schedule);
    }

    public String getSchedule() {
        return schedule;
    }
    public abstract String getInfo() throws SQLException;
}
