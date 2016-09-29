package com.example.mathias.weathersmap;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NetworkHandler {
    private static final String CONNECT = "CONNECTIVITY";
    private static final String WEATHER_API_KEY = "a111d736151b7b355e24269ad611a112";
    private static final long CITY_ID_AARHUS = 2624652;
    private static final String WEATHER_API_CALL = "http://api.openweathermap.org/data/2.5/weather?id=2624652&APPID=a111d736151b7b355e24269ad611a112";

    //Heavily inspired from the weatherservicedemo
    public String getCurrentWeatherData()
    {
        String line = "";
        try {
            URL url = new URL(WEATHER_API_CALL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);

            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            int response;
            conn.connect();
            response = conn.getResponseCode();
            Log.d("responsecode", Integer.toString(response));
            InputStream input = conn.getInputStream();

            String s = "";


            BufferedReader rd = new BufferedReader(new InputStreamReader(input));

            line = rd.readLine();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return line;
    }
}
