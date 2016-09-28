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
    private static final String WEATHER_API_CALL = "http://api.openweathermap.org/data/2.5/weather?id=" + CITY_ID_AARHUS + "&APPID=" + WEATHER_API_KEY;

    public void GetNewestWeatherData()
    {
        try {
            URL url = new URL(WEATHER_API_CALL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoInput(true);
            int response;
            do {
                conn.connect();
                response = conn.getResponseCode();
            }while(response != 200);

            InputStream input = conn.getInputStream();

            String s = "";
            String line = "";

            BufferedReader rd = new BufferedReader(new InputStreamReader(input));


            try {
                while ((line = rd.readLine()) != null) { s += line; }
            } catch (IOException ex) {
                Log.e(CONNECT, "ERROR reading HTTP response", ex);
                //ex.printStackTrace();
            }
        }
        catch(Exception e){

        }
    }
}
