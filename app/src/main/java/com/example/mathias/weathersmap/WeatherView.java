package com.example.mathias.weathersmap;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class WeatherView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_view);
        Log.d("Start", "StartSercice");
        Intent intent = new Intent(WeatherView.this, WeatherService.class);
        startService(intent);
    }

    public void click(View view){
        Intent intent = new Intent(WeatherView.this, WeatherService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    };

    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            WeatherService.ServiceBinder service = (WeatherService.ServiceBinder) iBinder;
            service.getService().Test();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
