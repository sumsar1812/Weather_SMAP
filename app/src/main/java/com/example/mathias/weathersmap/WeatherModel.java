package com.example.mathias.weathersmap;

import android.widget.ImageView;

import java.sql.Timestamp;

/**
 * Created by solveigdoan on 27/09/16.
 */
public class WeatherModel {
//android:src="@mipmap/weather"
    private int ID;
    private String Description;
    private int Temperature;
    private String CurrentDate;
    //private Timestamp timestamp_;




    public WeatherModel(int ID, String description, int temperature, String currentDate /*Timestamp timestamp_*/ ) {
        this.ID = ID;
        Description = description;
        Temperature = temperature;
        //this.timestamp_ = timestamp_;
        CurrentDate = currentDate;

    }
    public String getCurrentDate(){
        return CurrentDate;

    }

    public void setCurrentDate(String currentDate){
        CurrentDate = currentDate;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }
}

    //public Timestamp getTimestamp_() {
       // return timestamp_;
   // }

   // public void setTimestamp_(Timestamp timestamp_) {
       // this.timestamp_ = timestamp_;







    //private float Date;
    //private double Time;
   // private int WeatherIcon;


   /*konstruktører
    public WeatherModel(int ID, String description, int temperature, timestamp float date, double time) {
        this.ID = ID;
        Description = description;
        Temperature = temperature;
        Timestamp = timestamp;
       // Date = date;
        //Time = time;


    }

    //getter&Setter


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }


    public float getDate() {
        return Date;
    }

    public void setDate(float date) {
        Date = date;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double time) {
        Time = time;*/




