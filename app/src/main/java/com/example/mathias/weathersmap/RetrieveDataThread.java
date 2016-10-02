package com.example.mathias.weathersmap;


import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.json.JSONObject;


class RetrieveDataThread implements Runnable {
    private NetworkHandler networkHandler;
    private Intent intent;
    private Context context_;
    private int SLEEP_TIME_MS = 1*60*1000;
    RetrieveDataThread(Context context){
        this.intent = new Intent("RetrieveDataThread");
        networkHandler = new NetworkHandler();
        context_ = context;
    }
    public void run() {
        while(true) {
            String jsonString = networkHandler.getCurrentWeatherData();
            WeatherInfo weatherInfo = interpretJsonString(jsonString);
            WeatherDBHelper DbHelper = new WeatherDBHelper(context_);
            DbHelper.addWeather(weatherInfo);
            try {
                Log.d("", "Wait for 30 min");
                Intent broadCastIntent = new Intent();
                broadCastIntent.setAction("com.example.broadcast");
                context_.sendBroadcast(broadCastIntent);
                Thread.sleep(SLEEP_TIME_MS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public WeatherInfo interpretJsonString(String jsonString){
        WeatherInfo weatherInfo = new WeatherInfo();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");;
            weatherInfo.setDescription(description);
            double temperature = jsonObject.getJSONObject("main").getInt("temp");
            weatherInfo.setTemperature(temperature);
        }catch(Exception e){

        }
        return weatherInfo;
    }
}
