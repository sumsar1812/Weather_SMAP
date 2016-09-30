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
        return ServiceBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Start", "StartCommand");
        dbHelper = new WeatherDBHelper(this);
        RetrieveDataThread bk = new RetrieveDataThread(getApplicationContext());
        new Thread(bk).start();
        return super.onStartCommand(intent, flags, startId);
    }
    public WeatherInfo getCurrentWeather(){
        return dbHelper.getCurrentWeather();
    }
    public List<WeatherInfo> getPastWeather(){
        return dbHelper.getAllWeatherData();
    }
    public void Test(){
        Log.d("dfwef","efds");
    }
}

