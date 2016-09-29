package com.example.mathias.weathersmap;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
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

        weatherModelList.add(new WeatherInfo(1,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(2,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(3,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(4,"Cloudy", 17,"25-09-2016"));
        weatherModelList.add(new WeatherInfo(5,"Cloudy", 17,"25-09-2016"));

        adapter = new CustomAdapter(getApplicationContext(), weatherModelList);
        custom_listView.setAdapter(adapter);

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
