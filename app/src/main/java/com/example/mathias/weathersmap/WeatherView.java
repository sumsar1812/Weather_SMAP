package com.example.mathias.weathersmap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WeatherView extends AppCompatActivity {
    private ListView custom_listView;
    private CustomAdapter adapter;
    private List<WeatherInfo> weatherModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // CurrentWeather = (TextView)findViewById(R.id.currentWeather);
        //TempTxt = (TextView)findViewById(R.id.tempTxt);
        //DescrTxt = (TextView)findViewById(R.id.descrTxt);
        // UpdateTxt = (TextView)findViewById(R.id.updateTxt);

        custom_listView = (ListView)findViewById(R.id.custom_listView);

        //Get
        weatherModelList = new ArrayList<>();

        //adding sample data to test list


        adapter = new CustomAdapter(getApplicationContext(), weatherModelList);
        custom_listView.setAdapter(adapter);

        Log.d("Start", "StartSercice");
        Intent intent = new Intent(WeatherView.this, WeatherService.class);
        startService(intent);
        //TODO Var ikke sikker, men tænker at connAllWeatherInfo skal bindes her? for at hente alt info ud når appen startes vel?
    }

    public void click(View view){
        Intent intent = new Intent(WeatherView.this, WeatherService.class);
        bindService(intent, connCurrentWeatherInfo, BIND_AUTO_CREATE);
};

    ServiceConnection connAllWeatherInfo = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            WeatherService.ServiceBinder service = (WeatherService.ServiceBinder) iBinder;
            List<WeatherInfo> weahterList =  service.getService().getPastWeather();
            //TODO Needs UI update
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    ServiceConnection connCurrentWeatherInfo = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            WeatherService.ServiceBinder service = (WeatherService.ServiceBinder) iBinder;
            WeatherInfo weather = service.getService().getCurrentWeather();
            //TODO Needs ui update
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}
