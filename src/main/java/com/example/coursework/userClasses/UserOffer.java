package com.example.coursework.userClasses;

import com.example.coursework.userClasses.clubs.Club;

import java.util.ArrayList;

public class UserOffer {
    private String name;
    private String surname;
    private ArrayList<Club> clubList;
    private int sum=0;

    public UserOffer(String name, String surname, ArrayList<Club> clubList) {
        this.name = name;
        this.surname = surname;
        this.clubList = clubList;
    }
    public void addClub(Club club){
        clubList.add(club);
        sum+=club.getPrice();
    }
    public void deleteClub(Club club){
       if (clubList.contains(club)){
           clubList.remove(club);
           sum-=club.getPrice();
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<Club> getClubList() {
        return clubList;
    }

    /*public String clubCounter(){
        if(getNameList()==" "){

        }
    }*/
    public String getSumString(){
        String sumString=""+sum;
        return sumString;
    }
    public String getNameList(){
        String names=" ";
        for (Club club:clubList){
            names+=" "+club.getName()+";";
        }
        return names;
    }
}
