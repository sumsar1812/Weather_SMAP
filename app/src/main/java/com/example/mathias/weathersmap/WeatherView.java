package com.example.mathias.weathersmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
}
