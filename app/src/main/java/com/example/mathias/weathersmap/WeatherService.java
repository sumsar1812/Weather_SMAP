package com.example.mathias.weathersmap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherService extends Service {
    private boolean started = false;

    private ServiceBinder ServiceBinder = new ServiceBinder();
    WeatherDBHelper dbHelper;
    public class ServiceBinder extends Binder {
        public WeatherService getService() {
            return WeatherService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("Action", "Binding to Weather service");
        return ServiceBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Action", "onStartCommand - weatherService");
        dbHelper = new WeatherDBHelper(this);
        RetrieveDataThread bk = new RetrieveDataThread(getApplicationContext());
        new Thread(bk).start();
        return super.onStartCommand(intent, flags, startId);
    }
    public WeatherInfo getCurrentWeather(){
        Log.d("Action","getCurrentWeather - WeatherService");
        return dbHelper.getCurrentWeather();
    }
    public List<WeatherInfo> getPastWeather(){
        Log.d("Action","getPastWeather - WeatherService");
        return dbHelper.getAllWeatherData();
    }
}

