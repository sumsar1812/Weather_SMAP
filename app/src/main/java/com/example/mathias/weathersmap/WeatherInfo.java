package com.example.mathias.weathersmap;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Rasmus on 28-09-2016.
 */
public class WeatherInfo {
    private int id_;
    private String description_;
    private double temp_;
    private Timestamp timestamp_;

    public Timestamp getDate() { return timestamp_; }

    public void setDate(Timestamp date){
        timestamp_ = date;
    }

    public int getID() {
        return id_;
    }

    public void setID(int id) {
        this.id_ = id;
    }

    public String getDescription() {
        return description_;
    }

    public void setDescription(String description) {
        description_ = description;
    }

    public double getTemperature() {
        return temp_;
    }

    public void setTemperature(double temperature) {
        temp_ = temperature;
    }
}
