package com.example.mathias.weathersmap;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService extends Service {
    private boolean started = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Start", "StartCommand");
        RetrieveDataThread bk = new RetrieveDataThread(getApplicationContext());
        new Thread(bk).start();
        return super.onStartCommand(intent, flags, startId);
    }


}

