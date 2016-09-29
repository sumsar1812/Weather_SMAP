package com.example.mathias.weathersmap;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Rasmus on 28-09-2016.
 */
public class WeatherInfo {
    public int id;
    public String description;
    public double temp;
    public Timestamp timestamp;

    public String getCurrentDate(){
        return timestamp.toString();

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
